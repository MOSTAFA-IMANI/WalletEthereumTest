package com.example.wallettest.ui.feature.sign

import androidx.compose.runtime.Immutable

@Immutable
sealed interface SignUiState {
    object Loading : SignUiState
    object SignData : SignUiState
}