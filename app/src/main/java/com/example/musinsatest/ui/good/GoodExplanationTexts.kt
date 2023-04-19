package com.example.musinsatest.ui.good

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import com.example.musinsatest.data.Good
import com.example.musinsatest.priceFormat
import com.example.musinsatest.ui.theme.Typography
import com.example.musinsatest.R

@Composable
fun GoodExplanationTexts(good: Good, columnHeight: Dp) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(columnHeight * 0.2f)
    ) {
        GoodExplanationText(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.TopStart),
            text = good.brandName
        )
        GoodExplanationText(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .align(Alignment.BottomStart),
            text = good.price.priceFormat(),
            softWrap = true
        )
        GoodExplanationText(
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .align(Alignment.BottomEnd),
            text = stringResource(id = R.string.sale_rate, good.saleRate),
            color = Color.Red
        )
    }
}

@Composable
private fun GoodExplanationText(modifier: Modifier = Modifier, text: String, softWrap: Boolean = false, color: Color = Color.Black) {
    Text(
        modifier = modifier,
        text = text,
        style = Typography.body2,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        softWrap = softWrap,
        color = color
    )
}