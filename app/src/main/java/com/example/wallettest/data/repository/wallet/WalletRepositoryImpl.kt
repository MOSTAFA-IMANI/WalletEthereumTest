package com.example.wallettest.data.repository.wallet

import com.example.wallettest.data.datasourse.WalletDataSource
import org.web3j.crypto.Sign
import javax.inject.Inject

class WalletRepositoryImpl @Inject constructor(
    private val walletDataSource: WalletDataSource
) : WalletRepository {
    override suspend fun generateWallet() =
         walletDataSource.generateNewWallet()


    override fun getMnemonicCodeList(): List<String> = walletDataSource.getMnemonicCodeList()

    override fun getWalletAddress(): String  = walletDataSource.getWalletAddress()

    override fun getWalletPrivateKey(): String = walletDataSource.getWalletPrivateKey()

    override fun getWalletPublicKey(): String = walletDataSource.getWalletPublicKey()
    override fun signMessage(inputMessage: String): Sign.SignatureData =
        walletDataSource.signMessage(inputMessage)
}