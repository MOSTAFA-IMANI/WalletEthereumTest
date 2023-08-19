package com.example.wallettest.ui.feature.home

import androidx.compose.runtime.Immutable

@Immutable
sealed interface HomeUiState {
    object Loading : HomeUiState
    object WalletData : HomeUiState
}