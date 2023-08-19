package com.example.wallettest.data.repository.wallet

interface WalletRepository {
    fun generateMnemonicCodeList(entropySize:Int = 16 ):List<String>
}