package com.ankitangra.www.kmp_sample.core.data.remote

import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.parameter
import io.ktor.http.HeadersBuilder

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




