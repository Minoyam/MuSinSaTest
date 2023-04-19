package com.example.musinsatest.ui.header

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.musinsatest.ui.common.ContentImage
import com.example.musinsatest.R
import com.example.musinsatest.data.Header
import com.example.musinsatest.ui.theme.LightGray_Opacity80
import com.example.musinsatest.ui.theme.Typography

@Composable
fun HeaderContent(header: Header, uriHandler: UriHandler) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(5f)
            .padding(8.dp)
            .drawBehind {
                val borderSize = 1.dp.toPx()
                val y = size.height - borderSize / 2

                drawLine(
                    color = LightGray_Opacity80,
                    start = Offset(0f, y),
                    end = Offset(size.width, y),
                    strokeWidth = borderSize
                )
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (header.title.isNotEmpty()) {
            HeaderText(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(2f),
                text = header.title,
                style = Typography.subtitle1
            )
        }
        ContentImage(contentScale = ContentScale.Fit, url = header.iconURL)
        Spacer(modifier = Modifier.weight(0.5f))
        if (header.linkURL.isNotEmpty()) {
            TextButton(modifier = Modifier.weight(0.5f),
                onClick = {
                    uriHandler.openUri(header.linkURL)
                }) {
                HeaderText(
                    text = stringResource(R.string.all),
                    style = Typography.body1
                )
            }
        }
    }
}

@Composable
private fun HeaderText(modifier: Modifier = Modifier, text: String, style: TextStyle) {
    Text(
        modifier = modifier,
        text = text,
        style = style,
        color = Color.Black,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}