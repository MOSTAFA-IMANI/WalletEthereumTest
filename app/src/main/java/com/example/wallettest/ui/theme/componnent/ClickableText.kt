package com.example.wallettest.ui.theme.componnent

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun ClickableText(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = contentColorFor(backgroundColor),
    textAlign: TextAlign? = TextAlign.Start,
    style: TextStyle = LocalTextStyle.current,


    ) {
    Text(
        modifier =
        modifier
            .clickable { onClick.invoke() }
            .background(color = backgroundColor, shape = MaterialTheme.shapes.small)
            .padding(5.dp),
        text = text,
        color = contentColor,
        textAlign = textAlign,
        style = style
    )
}
