package com.example.wallettest.data.datasourse

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class WalletDataSourceImplTest{

    private lateinit var walletDataSource: WalletDataSource

    @Before
    fun setUp() {
        walletDataSource = WalletDataSourceImpl()
        walletDataSource.generateNewWallet(DefaultWalletSetting.initialEntropy, DefaultWalletSetting.passPhrase,DefaultWalletSetting.path)
    }

    @Test
    fun `generateNewWallet should initialize mnemonicList, address, and credentials`() {


        // Assert
        assertNotNull(walletDataSource.getMnemonicCodeList())
        assertNotNull(walletDataSource.getWalletAddress())
        assertNotNull(walletDataSource.getWalletPrivateKey())
        assertNotNull(walletDataSource.getWalletPublicKey())
    }

    @Test
    fun `getMnemonicCodeList should return initialized mnemonicList`() {

        // Act
        val mnemonicList = walletDataSource.getMnemonicCodeList()

        // Assert
        assertNotNull(mnemonicList)
        assertEquals(walletDataSource.getMnemonicCodeList(), mnemonicList)
    }

    @Test
    fun `getWalletAddress should return initialized address`() {


        // Act
        val address = walletDataSource.getWalletAddress()

        // Assert
        assertNotNull(address)
        assertEquals(walletDataSource.getWalletAddress(), address)
    }

    @Test
    fun `getWalletPrivateKey should return initialized private key`() {


        // Act
        val privateKey = walletDataSource.getWalletPrivateKey()

        // Assert
        assertNotNull(privateKey)
        assertEquals(walletDataSource.getWalletPrivateKey(), privateKey)
    }

    @Test
    fun `getWalletPublicKey should return initialized public key`() {


        // Act
        val publicKey = walletDataSource.getWalletPublicKey()

        // Assert
        assertNotNull(publicKey)
        assertEquals(walletDataSource.getWalletPublicKey(), publicKey)
    }

    @Test
    fun `signMessage should return valid signature data`() {
        // Arrange
        val inputMessage = "Hello, world!"

        // Act
        val signatureData = walletDataSource.signMessage(inputMessage)

        // Assert
        assertNotNull(signatureData)
    }

}