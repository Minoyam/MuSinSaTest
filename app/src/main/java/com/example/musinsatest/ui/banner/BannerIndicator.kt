package com.example.musinsatest.ui.banner

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.musinsatest.ui.common.ContentImage
import com.example.musinsatest.data.Data
import com.example.musinsatest.ui.theme.Black_Opacity60
import com.example.musinsatest.ui.theme.White_Opacity20
import kotlinx.coroutines.delay
import com.example.musinsatest.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BannerIndicator(data: Data, uriHandler: UriHandler) {
    val pageCount = data.contents.banners.size
    val pagerState = rememberPagerState()

    LaunchedEffect(Unit) {
        while (true) {
            delay(3000)
            if (pagerState.canScrollForward) {
                pagerState.animateScrollToPage(pagerState.currentPage + 1)
            } else {
                pagerState.animateScrollToPage(0)
            }
        }
    }
    HorizontalPager(
        pageCount = pageCount,
        state = pagerState,
        modifier = Modifier.fillMaxWidth()
    ) { page ->
        val banner = data.contents.banners[page]

        Box(modifier = Modifier
            .fillMaxWidth()
            .clickable {
                uriHandler.openUri(banner.linkURL)
            }) {
            ContentImage(modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.FillWidth, url = banner.thumbnailURL)
            Column(
                modifier = Modifier.align(Alignment.BottomStart),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                BannerText(
                    Modifier.background(shape = RoundedCornerShape(4.dp), color = White_Opacity20),
                    text = banner.title
                )
                BannerText(
                    Modifier.background(shape = RoundedCornerShape(4.dp), color = White_Opacity20),
                    text = banner.description
                )
                BannerText(
                    Modifier.background(shape = RoundedCornerShape(4.dp), color = White_Opacity20),
                    text = banner.keyword
                )
            }
            BannerText(
                Modifier
                    .background(shape = RoundedCornerShape(4.dp), color = Black_Opacity60)
                    .align(Alignment.BottomEnd), stringResource(id = R.string.banner_count, (page + 1), pageCount)
            )
        }
    }
}

@Composable
private fun BannerText(modifier: Modifier = Modifier, text: String) {
    if (text.isNotEmpty()) {
        Text(
            modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            text = text,
            color = Color.White
        )
    }
}