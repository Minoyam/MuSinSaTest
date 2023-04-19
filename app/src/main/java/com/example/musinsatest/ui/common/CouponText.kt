package com.example.musinsatest.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.musinsatest.R
import com.example.musinsatest.ui.theme.Blue_Opacity60

@Composable
fun CouponText(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier
            .background(Blue_Opacity60)
            .padding(4.dp),
        text = stringResource(R.string.coupon),
        color = Color.White,
        fontSize = 8.sp
    )
}