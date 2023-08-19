package com.example.wallettest.ui.feature.sign

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wallettest.data.repository.wallet.WalletRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.web3j.crypto.Sign
import org.web3j.utils.Numeric
import javax.inject.Inject


@HiltViewModel
class SignViewModel @Inject constructor(
    private val walletRepository: WalletRepository,
) : ViewModel() {

    private val _uiState: MutableStateFlow<SignUiState> = MutableStateFlow(SignUiState.Loading)
    val uiState: StateFlow<SignUiState> = _uiState
    private lateinit var signedData:Sign.SignatureData
    var inputMessage by mutableStateOf("test message input, you can edit it")
        private set

    init {
        signMessage()
    }
    private fun signMessage() {
        _uiState.update { SignUiState.Loading }
        viewModelScope.launch {
            signedData= walletRepository.signMessage(inputMessage)
            delay(10)
            _uiState.update { SignUiState.SignData }
        }
    }

    fun updateInputMessage(input: String) {
        inputMessage = input
        signMessage()
    }
    fun getSignDataHex():String{
        if(this::signedData.isInitialized){
           val retrieval =  signedData.r+signedData.s+signedData.v
            return Numeric.toHexString(retrieval)
        }
        return ""
    }
    fun getR():String = if(this::signedData.isInitialized)signedData.r.toString() else ""
    fun getS():String = if(this::signedData.isInitialized)signedData.s.toString() else ""
    fun getV():String =  if(this::signedData.isInitialized)signedData.v.toString() else ""


}
