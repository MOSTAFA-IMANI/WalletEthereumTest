

package com.example.wallettest.ui.feature.splash

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier



@Composable
fun SplashRoute(
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit,
) {
    SplashScreen(
        navigateToHome=navigateToHome,
        modifier = modifier
    )
}

@Composable
internal fun SplashScreen(
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit
) {
    Greeting("Test")
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}