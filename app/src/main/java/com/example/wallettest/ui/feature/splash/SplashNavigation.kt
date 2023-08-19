package com.example.wallettest.ui.feature.splash

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val splashNavigationRoute = "splash_route"

fun NavController.navigateToSplash(navOptions: NavOptions? = null) {
    this.navigate(splashNavigationRoute, navOptions)
}

fun NavGraphBuilder.splashScreen(
    navigateToHome: () -> Unit
) {
    composable(splashNavigationRoute) {
        SplashRoute(
            navigateToHome= navigateToHome
        )
    }
}