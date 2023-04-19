package com.example.musinsatest.data

sealed class Resource<T>(val data: T? = null, val errorMessage: String? = null, val code : Int) {

    class Success<T>(data: T, code: Int) : Resource<T>(data = data, code = code)

    class Error<T>(errorMessage: String?,code: Int) : Resource<T>(errorMessage = errorMessage, code = code)

}