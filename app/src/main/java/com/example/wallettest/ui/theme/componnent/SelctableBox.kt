package com.example.wallettest.ui.theme.componnent

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.wallettest.ui.util.extension.copyTextToClipboard


@Composable
fun SelectableBox(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    context :Context = LocalContext.current,
    onClick: () -> Unit = {context.copyTextToClipboard(title,description)},
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = contentColorFor(backgroundColor),
    textAlign: TextAlign? = TextAlign.Start,
    titleStyle: TextStyle = MaterialTheme.typography.bodyLarge,
    descriptionStyle: TextStyle =  MaterialTheme.typography.bodyMedium, ) {
    Column {
        Text(text = title, style = titleStyle)
        ClickableText(
            modifier = modifier,
            text = description,
            onClick = onClick,
            contentColor = contentColor,
            textAlign = textAlign,
            style = descriptionStyle,
        )
    }
}
@Composable
fun SelectableBox(
    modifier: Modifier = Modifier,
    title: String,
    description: List<String>,
    context :Context = LocalContext.current,
    onClick: () -> Unit = {context.copyTextToClipboard(title,description.joinToString())},
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = contentColorFor(backgroundColor),
    titleStyle: TextStyle = MaterialTheme.typography.bodyLarge,
    descriptionStyle: TextStyle =  MaterialTheme.typography.bodyMedium,
    ) {
    Column {
        Text(text = title, style = titleStyle)
        LazyVerticalGrid(
            modifier = modifier
                .padding(10.dp)
                .background(color = backgroundColor,shape = MaterialTheme.shapes.small)
                .clickable { onClick.invoke() },
            columns = GridCells.Fixed(4)
        ) {
            items(description) {
                Text(
                    modifier = modifier.padding(10.dp),
                    text = it,
                    style =descriptionStyle,
                    color = contentColor
                )
            }
        }
    }
}
