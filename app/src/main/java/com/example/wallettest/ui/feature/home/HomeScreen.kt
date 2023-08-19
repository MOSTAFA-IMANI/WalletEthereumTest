package com.example.wallettest.ui.feature.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import com.example.wallettest.ui.theme.componnent.CircularLoading
import com.example.wallettest.ui.theme.componnent.SelectableBox

private const val TAG = "HomeScreen"

@Composable
fun HomeRoute(
    modifier: Modifier = Modifier,
    navigateToSign: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    Log.d(TAG, "HomeRoute: $state")

    Log.d(TAG, "HomeRoute: Data : ${viewModel.getMnemonicList()}")
    HomeScreen(
        navigateToSign = navigateToSign,
        modifier = modifier,
        state = state,
        mnemonicList = viewModel.getMnemonicList(),
        walletAddress = viewModel.getWalletAddress(),
        walletPrivateKey = viewModel.getWalletPrivateKey(),
        regenerateWallet = viewModel::generateNewWalletInfo
    )
}


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToSign: () -> Unit,
    mnemonicList: List<String>,
    walletAddress: String,
    walletPrivateKey: String,
    regenerateWallet: () -> Unit,
    state: HomeUiState,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MnemonicCode(mnemonicList)
        AddressBox(walletAddress)
        PrivateKeyBox(walletPrivateKey)
        ControlButtons(regenerateWallet,navigateToSign)
    }
    when(state) {
        HomeUiState.Loading -> {
            Log.d(TAG, "HomeRoute:Loading")
            CircularLoading()
        }

        HomeUiState.WalletData -> {
            Log.d(TAG, "HomeRoute:WalletData")

        }
    }
}

@Composable
fun ControlButtons(regenerateWallet: () -> Unit, navigateToSign: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = regenerateWallet) {
            Text(text = stringResource(id = R.string.regenerate))
        }
        Button(onClick = navigateToSign) {
            Text(text = stringResource(id = R.string.signMessage_title))
        }
    }
}

@Composable
fun PrivateKeyBox(walletPrivateKey: String) {
    SelectableBox(
        title = stringResource(id = R.string.privateKey_title),
        description = walletPrivateKey,
    )
}

@Composable
fun AddressBox(walletAddress: String) {
    SelectableBox(
        title= stringResource(id = R.string.address_title),
        description=walletAddress,
    )
}

@Composable
fun MnemonicCode(mnemonicList: List<String>) {

    SelectableBox(
    title= stringResource(id = R.string.mnemonic_title),
    description=mnemonicList,
    )
}

