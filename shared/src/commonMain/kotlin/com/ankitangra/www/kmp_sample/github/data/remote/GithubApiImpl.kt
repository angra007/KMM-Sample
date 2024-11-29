package com.ankitangra.www.kmp_sample.github.data.remote

import com.ankitangra.www.kmp_sample.core.data.util.NetworkResult
import com.ankitangra.www.kmp_sample.core.data.remote.KmmAppKtorClient
import com.ankitangra.www.kmp_sample.core.data.remote.get
import com.ankitangra.www.kmp_sample.core.data.remote.toResult
import io.ktor.utils.io.core.toByteArray

class GithubApiImpl(
    private val client: KmmAppKtorClient
): GithubApi {

    override suspend fun getGithubList(): NetworkResult =
        client.get("").toResult()

    override suspend fun getGithubDetail(): NetworkResult =
        client.get("").toResult()

}