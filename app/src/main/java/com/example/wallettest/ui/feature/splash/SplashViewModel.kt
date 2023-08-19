package com.example.wallettest.ui.feature.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallettest.ui.feature.splash.SplashUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

internal class SplashViewModel () : ViewModel() {
    //    val state: StateFlow<SplashUiState> = SplashUiState.Loading
    private val _uiState: MutableStateFlow<SplashUiState> = MutableStateFlow(SplashUiState.Loading)

    // The UI collects from this StateFlow to get its state updates
    val uiState: StateFlow<SplashUiState> = _uiState

    init {
        viewModelScope.launch {
            delay(500)
            _uiState.value = SplashUiState.NavigateToWelcome

        }
    }
}
