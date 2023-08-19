package com.example.wallettest.data.repository.wallet

interface WalletRepository {
    fun generateWallet()

    fun getMnemonicCodeList(): List<String>

    fun getWalletAddress(): String

    fun getWalletPrivateKey(): String

    fun getWalletPublicKey(): String
}