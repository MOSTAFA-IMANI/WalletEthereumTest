package com.example.wallettest.ui.feature.sign

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

private const val signNavigationRoute = "sign_route"

fun NavController.navigateToSign(navOptions: NavOptions? = null) {
    this.navigate(signNavigationRoute, navOptions)
}

fun NavGraphBuilder.signScreen() {
    composable(signNavigationRoute) {
        SignRoute()
    }
}