package com.example.musinsatest.ui.good

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import com.example.musinsatest.ui.common.ContentImage
import com.example.musinsatest.ui.common.CouponText
import com.example.musinsatest.data.Good

@Composable
fun GoodImage(good: Good, columnHeight: Dp) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(columnHeight * 0.7f)
    ) {
        ContentImage(contentScale = ContentScale.FillHeight, url = good.thumbnailURL)
        if (good.hasCoupon) {
            CouponText(modifier = Modifier.align(Alignment.BottomStart))
        }
    }
}