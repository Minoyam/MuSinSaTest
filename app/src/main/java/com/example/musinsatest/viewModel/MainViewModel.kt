package com.example.musinsatest.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musinsatest.data.Data
import com.example.musinsatest.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _data = MutableStateFlow<List<Data>>(listOf())
    val data: StateFlow<List<Data>> get() = _data

    init {
        getContents()
    }

    private fun getContents() {
        viewModelScope.launch {
            repository.getContents().collect {
                if (it.code == 200) {
                    it.data?.let { contentsResponse ->
                        _data.emit(contentsResponse.dataList)
                    }
                }
            }
        }
    }
}