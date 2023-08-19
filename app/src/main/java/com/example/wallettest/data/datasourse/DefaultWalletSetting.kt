package com.example.wallettest.data.datasourse

import org.apache.commons.lang3.RandomStringUtils
import java.security.SecureRandom
import java.util.Random

object DefaultWalletSetting {
    private const val DEFAULT_ENTROPY_SIZE = 16
    private const val DEFAULT_PASSPHRASE_SIZE = 20
    private const val DEFAULT_PASSPHRASE_START = 0
    private const val DEFAULT_PASSPHRASE_END = 0
    private const val DEFAULT_PASSPHRASE_LETTER_SUPPORT = true
    private const val DEFAULT_PASSPHRASE_NUMBER_SUPPORT = true
    private val DEFAULT_PASSPHRASE_SPECIAL_CHAR: CharArray? = null
    private const val DEFAULT_PATH_PURPOSE: Int = 44
    private const val DEFAULT_PATH_CURRENCY: Int = 60
    private const val DEFAULT_PATH_ACCOUNT_LEVEL: Int = 0
    private const val DEFAULT_PATH_DERIVED_LEVEL: Int = 0
    private const val DEFAULT_PATH_CURRENT_LEVEL: Int = 0
    private val RANDOM_POLICY = SecureRandom()

    val initialEntropy: ByteArray
        get() = RANDOM_POLICY.getRandomByte(DEFAULT_ENTROPY_SIZE)

    val passPhrase: String
        get() = RandomStringUtils.random(
            DEFAULT_PASSPHRASE_SIZE,
            DEFAULT_PASSPHRASE_START,
            DEFAULT_PASSPHRASE_END,
            DEFAULT_PASSPHRASE_LETTER_SUPPORT,
            DEFAULT_PASSPHRASE_NUMBER_SUPPORT,
            DEFAULT_PASSPHRASE_SPECIAL_CHAR,
            RANDOM_POLICY
        )
    val path = intArrayOf(
        DEFAULT_PATH_PURPOSE,
        DEFAULT_PATH_CURRENCY,
        DEFAULT_PATH_ACCOUNT_LEVEL,
        DEFAULT_PATH_DERIVED_LEVEL,
        DEFAULT_PATH_CURRENT_LEVEL
    )

    private fun Random.getRandomByte(size: Int): ByteArray {
        val random = ByteArray(size)
        Random().nextBytes(random)
        return random
    }
}