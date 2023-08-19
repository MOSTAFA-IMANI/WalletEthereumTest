package com.example.wallettest.data.datasourse

import android.util.Log
import org.web3j.crypto.Bip32ECKeyPair
import org.web3j.crypto.Credentials
import org.web3j.crypto.MnemonicUtils
import org.web3j.crypto.Sign
import org.web3j.utils.Numeric
import java.nio.charset.StandardCharsets
import javax.inject.Inject


class WalletDataSourceImpl @Inject constructor() : WalletDataSource {
    private lateinit var mnemonicList:List<String>
    private lateinit var address:String
    private lateinit var credentials:Credentials

    override fun generateNewWallet(initialEntropy: ByteArray, passphrase: String, path: IntArray) {
        val  mnemonic = MnemonicUtils.generateMnemonic(initialEntropy)
        mnemonicList = mnemonic.split(" ")
        credentials = generateKeyCredentials(mnemonic,passphrase,path)
        address = credentials.address
    }

    override fun getMnemonicCodeList(): List<String> {
        return if(this::mnemonicList.isInitialized){
            mnemonicList
        }
        else{
            generateNewWallet()
            mnemonicList
        }
    }

    override fun getWalletAddress(): String {
        return if(this::address.isInitialized){
            address
        }
        else{
            generateNewWallet()
            address
        }
    }

    override fun getWalletPrivateKey(): String {
        return if(this::credentials.isInitialized){
            Numeric.toHexStringNoPrefix(credentials.ecKeyPair.privateKey)
        }
        else{
            generateNewWallet()
            Numeric.toHexStringNoPrefix(credentials.ecKeyPair.privateKey)

        }
    }

    override fun getWalletPublicKey(): String {
        return if(this::credentials.isInitialized){
            Numeric.toHexStringNoPrefix(credentials.ecKeyPair.publicKey)

        }
        else{
            generateNewWallet()
            Numeric.toHexStringNoPrefix(credentials.ecKeyPair.publicKey)

        }
    }

    override fun signMessage(inputMessage: String): Sign.SignatureData {
        val messageBytes: ByteArray = inputMessage.toByteArray(StandardCharsets.UTF_8)
        return if (this::credentials.isInitialized){
            Sign.signPrefixedMessage(messageBytes, credentials.ecKeyPair)
        } else{
            generateNewWallet()
            Sign.signPrefixedMessage(messageBytes, credentials.ecKeyPair)
        }
    }


    private fun generateKeyCredentials(
        mnemonic: String,
        passphrase: String,
        path: IntArray,
    ): Credentials {
        return Credentials.create(
            Bip32ECKeyPair.deriveKeyPair(
                generateMasterKey(mnemonic, passphrase),
                path,
            ),
        )
    }

    private fun generateMasterKey(
        mnemonic: String,
        passphrase: String,
    ): Bip32ECKeyPair {
        val seed = MnemonicUtils.generateSeed(mnemonic, passphrase)
        return Bip32ECKeyPair.generateKeyPair(seed)
    }

}