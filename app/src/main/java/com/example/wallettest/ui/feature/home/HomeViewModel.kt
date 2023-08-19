package com.example.wallettest.ui.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallettest.ui.feature.splash.SplashUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState.Loading)

    val uiState: StateFlow<HomeUiState> = _uiState

    fun navigateToSignScreen(){
            _uiState.value = HomeUiState.NavigateToSign

    }

    fun getMnemonicList(): List<String> {
        return listOf<String>("safd","asdj","testtest","asasd","asasd","test","asasd","asasd","asasd")
    }

    fun getWalletAddress(): String {
        return "test.testtest.testtest.testtest.testtest.testtest.test"
    }

    fun getWalletPrivateKey(): String {
        return "test.testtest.testtest.testtest.test"
    }
}
