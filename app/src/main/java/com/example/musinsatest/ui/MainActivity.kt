package com.example.musinsatest.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.example.musinsatest.ui.banner.BannerIndicator
import com.example.musinsatest.ui.good.grid.GridContent
import com.example.musinsatest.ui.good.scroll.ScrollContent
import com.example.musinsatest.ui.style.StyleContent
import com.example.musinsatest.data.Data
import com.example.musinsatest.ui.theme.*
import com.example.musinsatest.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MuSinSaTestTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    ContentsScreen()
                }
            }
        }
    }
}

@Composable
fun ContentsScreen(viewModel: MainViewModel = hiltViewModel()) {
    val dataList = viewModel.data.collectAsState()
    val uriHandler = LocalUriHandler.current

    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(dataList.value) {
            when (it.contents.type) {
                "BANNER" -> {
                    BannerIndicator(data = it, uriHandler = uriHandler)
                }
                "GRID" -> {
                    GridContent(data = it, uriHandler = uriHandler)
                }
                "SCROLL" -> {
                    ScrollContent(data = it, uriHandler = uriHandler)
                }
                "STYLE" -> {
                    StyleContent(data = it, uriHandler = uriHandler)
                }
            }
        }
    }
}

