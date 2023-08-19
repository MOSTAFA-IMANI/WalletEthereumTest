package com.example.wallettest.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.wallettest.ui.feature.home.homeScreen
import com.example.wallettest.ui.feature.home.navigateToHome
import com.example.wallettest.ui.feature.splash.splashNavigationRoute
import com.example.wallettest.ui.feature.splash.splashScreen

@Composable
fun DuckWalletNavgraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),

    ) {


    NavHost(
        navController = navController,
        startDestination = splashNavigationRoute
    ) {
        splashScreen(
            navigateToHome = {navController.navigateToHome(navOptions {
                popUpTo(splashNavigationRoute) { inclusive = true }
            })},
        )
        homeScreen {  }

    }

}
