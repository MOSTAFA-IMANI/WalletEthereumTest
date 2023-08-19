package com.example.wallettest.data.datasourse

interface WalletDataSource {

    fun generateNewWallet(
        initialEntropy: ByteArray = DefaultWalletSetting.initialEntropy,
        passphrase: String = DefaultWalletSetting.passPhrase,
        path : IntArray = DefaultWalletSetting.path
    )

    fun getMnemonicCodeList(): List<String>

    fun getWalletAddress(): String

    fun getWalletPrivateKey(): String

    fun getWalletPublicKey(): String

}