package com.ankitangra.www.kmp_sample.github.data.remote

import com.ankitangra.www.kmp_sample.core.data.util.NetworkResult
import com.ankitangra.www.kmp_sample.core.data.remote.KmmAppKtorClient
import io.ktor.utils.io.core.toByteArray

class GithubApiImpl(
    private val client: KmmAppKtorClient
): GithubApi {

    override suspend fun getGithubList(): NetworkResult {
        return NetworkResult.Success("".toByteArray())
    }

    override suspend fun getGithubDetail(): NetworkResult {
        return NetworkResult.Success("".toByteArray())
    }

}