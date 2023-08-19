package com.example.wallettest.ui.feature.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallettest.data.repository.wallet.WalletRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val walletRepository: WalletRepository,
) : ViewModel() {

    private val TAG = "HomeViewModel"
    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState


    init {
        generateNewWalletInfo()
        _uiState.value = HomeUiState.WalletData
    }

    fun generateNewWalletInfo() {
        _uiState.value = HomeUiState.Loading
        viewModelScope.launch {
            walletRepository.generateWallet()
            delay(10)
            _uiState.value = HomeUiState.WalletData
        }

    }

    fun getMnemonicList(): List<String> {
        return walletRepository.getMnemonicCodeList()
    }

    fun getWalletAddress(): String {
        return walletRepository.getWalletAddress()
    }

    fun getWalletPrivateKey(): String {
        return walletRepository.getWalletPrivateKey()
    }
}
