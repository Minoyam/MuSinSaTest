package com.example.musinsatest

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import com.example.musinsatest.data.Resource
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.text.DecimalFormat


fun <T> safeApiCall(response: Response<T>): Resource<T> {
    return try {
        if (response.isSuccessful) {
            val data = response.body()
            if (data != null) {
                Resource.Success(data = data, response.code())
            } else {
                Resource.Error(
                    errorMessage = "Data is Empty",
                    code = response.code()
                )
            }
        } else {
            Resource.Error(
                errorMessage = response.errorBody()?.string(),
                code = response.code()
            )
        }

    } catch (e: HttpException) {
        Resource.Error(errorMessage = e.message, code = e.code())
    } catch (e: IOException) {
        Resource.Error(errorMessage = e.message, code = 0)
    } catch (e: Exception) {
        Resource.Error(errorMessage = e.message, code = 0)
    }
}

fun Int.priceFormat() = DecimalFormat("###,###").format(this) + "원"

fun Modifier.noRippleClickable( onClick: ()->Unit): Modifier = composed {
    clickable(indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
}