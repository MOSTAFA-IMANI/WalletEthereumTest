package com.example.wallettest.ui.feature.splash

import androidx.compose.runtime.Immutable

@Immutable
sealed interface SplashUiState {
    object Loading : SplashUiState
    object NavigateToLogin : SplashUiState
    object NavigateToWelcome : SplashUiState
    object NavigateToHome : SplashUiState
}