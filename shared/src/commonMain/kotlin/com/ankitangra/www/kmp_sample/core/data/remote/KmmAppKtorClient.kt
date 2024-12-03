package com.ankitangra.www.kmp_sample.core.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout

class KmmAppKtorClient (
    private val client: HttpClient,
) {
    fun instance(): HttpClient {
        return client.config {
            install(HttpTimeout) {
                requestTimeoutMillis = 30000
                connectTimeoutMillis = 30000
            }
        }
    }
}
