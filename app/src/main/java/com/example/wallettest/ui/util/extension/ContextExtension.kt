package com.example.wallettest.ui.util.extension

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import com.example.wallettest.R

fun Context.copyTextToClipboard(label:String, text:String){
    val clipboardManager =
        this.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clipData = ClipData.newPlainText(label,text)
    clipboardManager.setPrimaryClip(clipData)
    Toast.makeText(this, R.string.copiedText,Toast.LENGTH_LONG).show()
}