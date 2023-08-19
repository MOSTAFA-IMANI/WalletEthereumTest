package com.example.wallettest.ui.feature.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallettest.ui.feature.splash.SplashUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * I've added this screen to can scale later the project and be able to navigate the app in UI test */
@HiltViewModel
class SplashViewModel @Inject constructor(

) : ViewModel() {

    private val _uiState: MutableStateFlow<SplashUiState> = MutableStateFlow(SplashUiState.Loading)

    // The UI collects from this StateFlow to get its state updates
    val uiState: StateFlow<SplashUiState> = _uiState

    init {
        viewModelScope.launch {
            // navigate to Home Screen after a delay
            delay(500)
            _uiState.value = SplashUiState.NavigateToHome
        }
    }
}
