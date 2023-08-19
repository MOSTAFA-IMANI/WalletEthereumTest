package com.example.wallettest.data.datasourse

interface WalletDataSource {

    fun generateMnemonicCodeList(entropySize:Int):List<String>

}