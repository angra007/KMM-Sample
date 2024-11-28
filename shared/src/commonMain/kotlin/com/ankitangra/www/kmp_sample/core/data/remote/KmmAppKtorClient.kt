package com.ankitangra.www.kmp_sample.core.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout

class KmmAppKtorClient (
    val client: HttpClient,
) {

    fun instance(): HttpClient {
        return client.config {
            // Configure timeout settings
            install(HttpTimeout) {
                requestTimeoutMillis = 30000 // 30 seconds
                connectTimeoutMillis = 30000 // 30 seconds
                socketTimeoutMillis = 30000 // 30 seconds
            }
        }
    }

}