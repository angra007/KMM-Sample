package com.ankitangra.www.kmp_sample.github.data.remote

import com.ankitangra.www.kmp_sample.core.data.model.NetworkResult

interface GithubApi {
    suspend fun getGithubList(): NetworkResult
    suspend fun getGithubDetail(): NetworkResult
}