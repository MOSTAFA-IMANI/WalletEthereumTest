package com.example.wallettest.ui.theme.componnent

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun CircularLoading(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.secondary,
    alignment: Alignment = Alignment.Center,
    strokeWidth : Dp = 5.dp,
    ) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = alignment
    ) {

        CircularProgressIndicator(
            modifier = modifier.drawBehind {
                drawCircle(
                    color = color,
                    radius = size.width / 2 - strokeWidth.toPx() / 2,
                    style = Stroke(strokeWidth.toPx())
                )
            },
            color = Color.LightGray,
            strokeWidth = strokeWidth
        )
    }
}
