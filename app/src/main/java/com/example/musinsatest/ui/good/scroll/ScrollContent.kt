package com.example.musinsatest.ui.good.scroll

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Shapes
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.unit.dp
import com.example.musinsatest.ui.footer.FooterContent
import com.example.musinsatest.ui.header.HeaderContent
import com.example.musinsatest.data.Data
import com.example.musinsatest.ui.good.GoodExplanationTexts
import com.example.musinsatest.ui.good.GoodImage

@Composable
fun ScrollContent(data: Data, uriHandler: UriHandler) {
    val configuration = LocalConfiguration.current

    val columnWidth = configuration.screenWidthDp.dp / 3.4f
    val columnHeight = columnWidth.times(1.7f)
    val gridHeight = columnHeight * 2

    var goodsRemember by remember { mutableStateOf(data.contents.goods) }

    Card(modifier = Modifier.padding(8.dp), shape = Shapes().medium, elevation = 8.dp) {
        Column {
            data.header?.let { header ->
                HeaderContent(header = header, uriHandler = uriHandler)
            }
            LazyHorizontalGrid(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(gridHeight),
                rows = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp)
            )
            {
                items(items = goodsRemember) { good ->
                    Column(
                        modifier = Modifier
                            .width(columnWidth)
                            .height(columnHeight)
                            .padding(8.dp)
                            .clickable {
                                uriHandler.openUri(good.linkURL)
                            }
                    ) {
                        GoodImage(good = good, columnHeight = columnHeight)
                        GoodExplanationTexts(good = good, columnHeight = columnHeight)
                    }
                }
            }
            if (data.footer != null) {
                FooterContent(footer = data.footer) {
                    when (it) {
                        "REFRESH" -> {
                            goodsRemember = goodsRemember.shuffled()
                        }
                    }
                }
            }
        }
    }
}