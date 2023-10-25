package com.wingsmight.boilerplate.common.domain.usecase

import com.google.gson.Gson
import com.wingsmight.boilerplate.common.Resource
import com.wingsmight.boilerplate.data.remote.dto.ResourceErrorDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

abstract class UseCase<T> {
    protected fun execute(
        block: suspend () -> T
    ): Flow<Resource<T>> = flow {
        try {
            emit(Resource.Loading())
            val result = block.invoke()

            emit(Resource.Success(result))
        } catch (e: HttpException) {
            val errorResponse = convertErrorResponse(e)
            emit(Resource.Failure(errorResponse.localizedMessage))
        } catch (e: IOException) {
            emit(Resource.Failure("Couldn't reach the server. Check your internet connection."))
        } catch (e: Exception) {
            emit(Resource.Failure(e.localizedMessage))
        }
    }
}

private fun convertErrorResponse(e: HttpException): ResourceErrorDto {
    val errorBody = e.response()?.errorBody()?.string()
    val errorResponse = Gson().fromJson(errorBody, ResourceErrorDto::class.java)

    return errorResponse ?: ResourceErrorDto(e.code(), e.message())
}
