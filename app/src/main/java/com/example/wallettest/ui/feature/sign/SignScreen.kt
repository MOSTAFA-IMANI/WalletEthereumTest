package com.example.wallettest.ui.feature.sign

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.wallettest.R
import com.example.wallettest.ui.theme.componnent.CircularLoading
import com.example.wallettest.ui.theme.componnent.SelectableBox
import com.example.wallettest.ui.util.extension.copyTextToClipboard


@Composable
fun SignRoute(
    viewModel: SignViewModel = hiltViewModel(),
) {
    val modifier: Modifier = Modifier.padding(10.dp)
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    SignScreen(
        modifier = modifier,
        onInputMessageChange = viewModel::updateInputMessage,
        inputMessage = viewModel.inputMessage,
        signedHex = viewModel.getSignDataHex(),
        signedR = viewModel.getR(),
        signedS = viewModel.getS(),
        signedV = viewModel.getV(),
        state = state
    )
}

@Composable
fun SignScreen(
    modifier: Modifier = Modifier,
    state: SignUiState,
    inputMessage: String,
    onInputMessageChange: (String) -> Unit,
    signedHex: String,
    signedR: String,
    signedS: String,
    signedV: String,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        InputBox(inputMessage, onInputMessageChange)
        SelectableBox(
            title = stringResource(id = R.string.signedHex_title), description = signedHex
        )
        SelectableBox(
            title = stringResource(id = R.string.signedR_title),
            description = signedR)
        SelectableBox(
            title = stringResource(id = R.string.signedS_title)
            , description = signedS)
        SelectableBox(
            title = stringResource(id = R.string.signedV_title),
            description = signedV)

    }

    when (state) {
        SignUiState.Loading -> {
            CircularLoading(modifier)
        }

        SignUiState.SignData -> {

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputBox(inputMessage: String, onInputMessageChange: (String) -> Unit) {
    val context = LocalContext.current
    val title = stringResource(id = R.string.inputMessage_title)
    Text(text = title)
    TextField(
        modifier = Modifier.clickable { context.copyTextToClipboard(title, inputMessage) },
        value = inputMessage,
        onValueChange = onInputMessageChange
    )

}
