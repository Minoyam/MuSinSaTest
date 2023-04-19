package com.example.musinsatest.ui.style

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.Shapes
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import com.example.musinsatest.ui.common.ContentImage
import com.example.musinsatest.ui.footer.FooterContent
import com.example.musinsatest.ui.header.HeaderContent
import com.example.musinsatest.data.Data
import com.example.musinsatest.data.Style
import kotlin.math.ceil

@Composable
fun StyleContent(data: Data, uriHandler: UriHandler) {
    val configuration = LocalConfiguration.current

    var stylesRemember by remember { mutableStateOf(data.contents.styles) }
    var maxSizeRemember by remember { mutableStateOf(6) }

    val columnWidth = configuration.screenWidthDp.dp / 3
    val columnHeight = (columnWidth.times(1.5f))
    val gridHeight = (ceil(maxSizeRemember / 3f) + 1) * columnHeight

    Card(modifier = Modifier.padding(8.dp), shape = Shapes().medium, elevation = 8.dp) {
        Column {
            data.header?.let { header ->
                HeaderContent(header = header, uriHandler = uriHandler)
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .height(gridHeight),
                userScrollEnabled = false
            ) {
                items(stylesRemember.size) { index ->
                    if (index == 0) {
                        MergeSpanRow(stylesRemember, columnWidth, columnHeight, uriHandler)
                    } else if (index > 2) {
                        LazyVerticalGrid(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(gridHeight),
                            columns = GridCells.Fixed(3),
                            userScrollEnabled = false
                        ) {
                            items(items = stylesRemember.drop(3)) { style ->
                                ContentImage(
                                    modifier = Modifier
                                        .width(columnWidth)
                                        .height(columnHeight)
                                        .padding(4.dp)
                                        .clickable { uriHandler.openUri(style.linkURL) },
                                    contentScale = ContentScale.FillHeight,
                                    url = style.thumbnailURL
                                )
                            }
                        }
                    }
                }
            }
            if (data.footer != null && maxSizeRemember < stylesRemember.size) {
                FooterContent(footer = data.footer) {
                    when (it) {
                        "MORE" -> {
                            maxSizeRemember += 3
                            if (maxSizeRemember > stylesRemember.size) {
                                maxSizeRemember = stylesRemember.size
                            }
                        }
                        "REFRESH" -> {
                            stylesRemember = stylesRemember.shuffled()
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun MergeSpanRow(
    stylesRemember: List<Style>,
    columnWidth: Dp,
    columnHeight: Dp,
    uriHandler: UriHandler
) {
    Row {
        ContentImage(
            modifier = Modifier
                .width((columnWidth * 2))
                .height((columnHeight * 2))
                .padding(4.dp)
                .clickable { uriHandler.openUri(stylesRemember[0].linkURL) },
            contentScale = ContentScale.FillHeight, url = stylesRemember[0].thumbnailURL
        )
        if (stylesRemember.size > 1)
            Column(
                modifier = Modifier
                    .width(columnWidth)
                    .height(columnHeight * 2),
            ) {
                ContentImage(
                    modifier = Modifier
                        .width(columnWidth)
                        .height(columnHeight)
                        .padding(4.dp)
                        .clickable { uriHandler.openUri(stylesRemember[1].linkURL) },
                    contentScale = ContentScale.FillHeight, url = stylesRemember[1].thumbnailURL
                )
                if (stylesRemember.size > 2) {
                    ContentImage(
                        modifier = Modifier
                            .width(columnWidth)
                            .height(columnHeight)
                            .padding(4.dp)
                            .clickable { uriHandler.openUri(stylesRemember[2].linkURL) },
                        contentScale = ContentScale.FillHeight, url = stylesRemember[2].thumbnailURL
                    )
                }
            }
    }
}