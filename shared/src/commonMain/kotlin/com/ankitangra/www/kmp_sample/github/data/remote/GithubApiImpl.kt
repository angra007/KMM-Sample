package com.ankitangra.www.kmp_sample.github.data.remote

import com.ankitangra.www.kmp_sample.core.data.model.NetworkResult
import com.ankitangra.www.kmp_sample.core.data.remote.KmmAppKtorClient

class GithubApiImpl(
    private val client: KmmAppKtorClient
): GithubApi {

    override suspend fun getGithubList(): NetworkResult {
        TODO("Not yet implemented")
    }

    override suspend fun getGithubDetail(): NetworkResult {
        TODO("Not yet implemented")
    }

}