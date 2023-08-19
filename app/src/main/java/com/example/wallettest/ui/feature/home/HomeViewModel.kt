package com.example.wallettest.ui.feature.home

import androidx.lifecycle.ViewModel
import com.example.wallettest.data.repository.wallet.WalletRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val walletRepository: WalletRepository,
) : ViewModel() {

    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState.Loading)

    val uiState: StateFlow<HomeUiState> = _uiState

    fun navigateToSignScreen() {
        _uiState.value = HomeUiState.NavigateToSign

    }

    fun getMnemonicList(): List<String> {
        return walletRepository.generateMnemonicCodeList()
    }

    fun getWalletAddress(): String {
        return "test.testtest.testtest.testtest.testtest.testtest.test"
    }

    fun getWalletPrivateKey(): String {
        return "test.testtest.testtest.testtest.test"
    }
}
