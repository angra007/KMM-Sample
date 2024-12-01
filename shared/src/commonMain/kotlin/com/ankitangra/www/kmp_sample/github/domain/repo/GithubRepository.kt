package com.ankitangra.www.kmp_sample.github.domain.repo

import com.ankitangra.www.kmp_sample.github.domain.models.GithubSearchResult

interface GithubRepository {
    suspend fun getGithubUser(name: String): List<GithubSearchResult>
}