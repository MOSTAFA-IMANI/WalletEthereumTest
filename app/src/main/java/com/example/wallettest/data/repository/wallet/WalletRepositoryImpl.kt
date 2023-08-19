package com.example.wallettest.data.repository.wallet

import com.example.wallettest.data.datasourse.WalletDataSource
import javax.inject.Inject

class WalletRepositoryImpl @Inject constructor(
    private val walletDataSource: WalletDataSource
) : WalletRepository {
    override fun generateMnemonicCodeList(entropySize: Int): List<String> {
        return walletDataSource.generateMnemonicCodeList(entropySize)
    }
}