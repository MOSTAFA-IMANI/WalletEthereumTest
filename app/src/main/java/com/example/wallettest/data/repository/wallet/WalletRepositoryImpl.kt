package com.example.wallettest.data.repository.wallet

import com.example.wallettest.data.datasourse.WalletDataSource
import javax.inject.Inject

class WalletRepositoryImpl @Inject constructor(
    private val walletDataSource: WalletDataSource
) : WalletRepository {
    override fun generateWallet() =
         walletDataSource.generateNewWallet()


    override fun getMnemonicCodeList(): List<String> = walletDataSource.getMnemonicCodeList()

    override fun getWalletAddress(): String  = walletDataSource.getWalletAddress()

    override fun getWalletPrivateKey(): String = walletDataSource.getWalletPrivateKey()

    override fun getWalletPublicKey(): String = walletDataSource.getWalletPublicKey()
}