package com.example.wallettest.ui.feature.home

import org.web3j.crypto.MnemonicUtils
import java.security.PrivateKey

data class WalletInfo(
    val mnemonicList: List<String>,
    val privateKey : String,
    val address : String
)
