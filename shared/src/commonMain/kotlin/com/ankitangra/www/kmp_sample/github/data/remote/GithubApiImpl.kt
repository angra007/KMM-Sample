package com.ankitangra.www.kmp_sample.github.data.remote

import com.ankitangra.www.kmp_sample.BaseConfig
import com.ankitangra.www.kmp_sample.core.data.util.NetworkResult
import com.ankitangra.www.kmp_sample.core.data.remote.KmmAppKtorClient
import com.ankitangra.www.kmp_sample.core.data.remote.get
import com.ankitangra.www.kmp_sample.core.data.remote.toResult
import io.ktor.utils.io.core.toByteArray
import kotlinx.coroutines.delay

class GithubApiImpl(
    private val client: KmmAppKtorClient
): GithubApi {

    override suspend fun getGithubUser(name: String): NetworkResult {
        return client.get(BaseConfig.BASE_URL + "users/$name").toResult()
    }

    override suspend fun searchGithubOrg(query: String): NetworkResult {
        return client.get(BaseConfig.BASE_URL + "search/users?q=$query").toResult()
    }
}