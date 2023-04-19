package com.example.musinsatest.ui.good.grid

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Shapes
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import com.example.musinsatest.ui.footer.FooterContent
import com.example.musinsatest.ui.header.HeaderContent
import com.example.musinsatest.data.Data
import com.example.musinsatest.ui.good.GoodExplanationTexts
import com.example.musinsatest.ui.good.GoodImage
import kotlin.math.ceil

@Composable
fun GridContent(data: Data, uriHandler: UriHandler) {
    val configuration = LocalConfiguration.current

    var goodsRemember by remember { mutableStateOf(data.contents.goods) }
    var maxSizeRemember by remember { mutableStateOf(6) }

    val columnWidth = configuration.screenWidthDp.dp / 3
    val columnHeight = columnWidth.times(1.5f)
    val gridHeight = ceil((maxSizeRemember / 3.0)) * columnHeight

    Card(modifier = Modifier.padding(8.dp), shape = Shapes().medium, elevation = 8.dp) {
        Column {
            data.header?.let { header ->
                HeaderContent(header = header, uriHandler = uriHandler)
            }
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(gridHeight),
                columns = GridCells.Fixed(3),
                contentPadding = PaddingValues(8.dp),
                userScrollEnabled = false
            )
            {
                items(items = goodsRemember.take(maxSizeRemember)) { good ->
                    Column(
                        modifier = Modifier
                            .width(columnWidth)
                            .height(columnHeight)
                            .padding(4.dp)
                            .clickable {
                                uriHandler.openUri(good.linkURL)
                            }
                    ) {
                        GoodImage(good = good, columnHeight = columnHeight)
                        GoodExplanationTexts(good = good, columnHeight = columnHeight)
                    }
                }
            }
            if (data.footer != null && maxSizeRemember < goodsRemember.size) {
                FooterContent(footer = data.footer) {
                    when (it) {
                        "MORE" -> {
                            maxSizeRemember += 3
                            if (maxSizeRemember > goodsRemember.size) {
                                maxSizeRemember = goodsRemember.size
                            }
                        }
                        "REFRESH" -> {
                            goodsRemember = goodsRemember.shuffled()
                        }
                    }
                }
            }
        }
    }
}