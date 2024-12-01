package com.ankitangra.www.kmp_sample.github.data.remote

import com.ankitangra.www.kmp_sample.core.data.util.NetworkResult

interface GithubApi {
    suspend fun getGithubUser(name: String): NetworkResult
    suspend fun getGithubOrg(name: String): NetworkResult
}