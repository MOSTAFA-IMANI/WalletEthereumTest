package com.example.wallettest.ui.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.wallettest.R
import com.example.wallettest.ui.theme.componnent.SelectableBox


@Composable
fun HomeRoute(
    modifier: Modifier = Modifier,
    navigateToSign: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    HomeScreen(
        navigateToSign = navigateToSign,
        modifier = modifier,
        state = state,
        mnemonicList = viewModel.getMnemonicList(),
        walletAddress = viewModel.getWalletAddress(),
        walletPrivateKey =viewModel.getWalletPrivateKey()
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToSign: () -> Unit,
    mnemonicList: List<String>,
    state: HomeUiState,
    walletAddress: String,
    walletPrivateKey: String,
) {
    Column(
        modifier = modifier.fillMaxSize().padding(10.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MnemonicCode(mnemonicList)
        AddressBox(walletAddress)
        PrivateKeyBox(walletPrivateKey)
    }


}

@Composable
fun PrivateKeyBox(walletPrivateKey: String) {
    SelectableBox(
        title= stringResource(id = R.string.privateKey_title),
        description=walletPrivateKey,
        onClick={},
    )
}

@Composable
fun AddressBox(walletAddress: String) {
    SelectableBox(
        title= stringResource(id = R.string.address_title),
        description=walletAddress,
        onClick={},
    )
}

@Composable
fun MnemonicCode(mnemonicList: List<String>) {
    SelectableBox(
    title= stringResource(id = R.string.mnemonic_title),
    description=mnemonicList,
    onClick={},
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}