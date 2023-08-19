package com.example.wallettest.ui.feature.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

private const val homeNavigationRoute = "home_route"

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    this.navigate(homeNavigationRoute, navOptions)
}

fun NavGraphBuilder.homeScreen(
    navigateToSign: () -> Unit
) {
    composable(homeNavigationRoute) {
        HomeRoute(
            navigateToSign= navigateToSign
        )
    }
}