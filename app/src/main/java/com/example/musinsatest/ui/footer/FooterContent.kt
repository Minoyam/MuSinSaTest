package com.example.musinsatest.ui.footer

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.musinsatest.ui.common.ContentImage
import com.example.musinsatest.data.Footer
import com.example.musinsatest.noRippleClickable

@Composable
fun FooterContent(footer: Footer, onClick: (String) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(32.dp))
                .padding(vertical = 8.dp)
                .noRippleClickable { onClick(footer.type) },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.weight(1f))
            ContentImage(contentScale = ContentScale.Fit, url = footer.iconURL)
            if (footer.title.isNotEmpty()) {
                Text(modifier = Modifier.padding(start = 8.dp), text = footer.title, color = Color.Black)
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}