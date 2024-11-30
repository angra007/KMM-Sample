package com.ankitangra.www.kmp_sample.core.data.remote

import com.ankitangra.www.kmp_sample.core.data.model.ApiWrapper
import com.ankitangra.www.kmp_sample.core.data.util.NetworkResult
import com.ankitangra.www.kmp_sample.core.data.util.toObject
import io.github.aakira.napier.Napier
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HeadersBuilder
import kotlinx.serialization.json.Json

suspend inline fun KmmAppKtorClient.get(
    url: String,
    noinline headers: HeadersBuilder.() -> Unit = {},
    vararg params: Pair<String, Any>
) = runCatching {
    instance().get(url) {
        headers(headers)
        params.forEach {
            parameter(it.first, it.second)
        }
    }
}

suspend fun Result<HttpResponse>.toResult(): NetworkResult {
    return when {
        isSuccess -> getOrThrow().run {

            when (this.status.value) {
                200, 201, 202, 204, 205 -> {
                    NetworkResult.Success(body())
                }

                400 -> {
                    NetworkResult.Error(
                        Exception(
                            "Something went wrong! Please try again later."
                        )
                    )
                }

                401 -> {
                    NetworkResult.Error(
                        Exception(
                            "Authorization Failed! Try Logging In again."
                        )
                    )
                }

                in listOf(500, 503) -> {
                    NetworkResult.Error(
                        Exception(
                            "Server Disruption! We are on fixing it."
                        )
                    )
                }

                504 -> {
                    NetworkResult.Error(
                        Exception(
                            "Too much load at this time, try again later!"
                        )
                    )
                }

                else -> {
                    NetworkResult.Error(
                        Exception(
                            "Something went wrong! Please try again later."
                        )
                    )
                }
            }
        }

        else -> {
            //Napier.e("HttpFailure -> ${this.exceptionOrNull()?.message}")
            //Napier.e("HttpFailure -> ${this.exceptionOrNull()?.cause?.message}")
            //this.exceptionOrNull()?.printStackTrace()
            NetworkResult.Error(Exception("Something went wrong! Please try again later."))
        }
    }

}

inline fun <reified T> NetworkResult.Success.toApiResponse(json: Json): ApiWrapper<T> {
    return  json.toObject<ApiWrapper<T>>(this.data.decodeToString())
}

