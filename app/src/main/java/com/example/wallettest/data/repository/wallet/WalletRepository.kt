package com.example.wallettest.data.repository.wallet

import org.web3j.crypto.Sign

interface WalletRepository {
    suspend fun generateWallet()

    fun getMnemonicCodeList(): List<String>

    fun getWalletAddress(): String

    fun getWalletPrivateKey(): String

    fun getWalletPublicKey(): String

    fun signMessage(inputMessage:String): Sign.SignatureData

}