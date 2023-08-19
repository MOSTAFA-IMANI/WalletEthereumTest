package com.example.wallettest.data.datasourse

import org.web3j.crypto.MnemonicUtils
import java.util.Random
import javax.inject.Inject

class WalletDataSourceImpl @Inject constructor() : WalletDataSource {
    override fun generateMnemonicCodeList(entropySize: Int): List<String> {
        val initialEntropy = ByteArray(entropySize)
        Random().nextBytes(initialEntropy)
        val mnemonic = MnemonicUtils.generateMnemonic(initialEntropy)
        return mnemonic.split(" ")
    }
}