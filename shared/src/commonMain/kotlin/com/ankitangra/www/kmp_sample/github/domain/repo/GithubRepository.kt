package com.ankitangra.www.kmp_sample.github.domain.repo

import com.ankitangra.www.kmp_sample.github.domain.models.GithubSearchResult
import com.ankitangra.www.kmp_sample.github.domain.models.GithubUser

interface GithubRepository {
    suspend fun getGithubUser(name: String): GithubUser
    suspend fun searchUser(query: String): List<GithubSearchResult>
}