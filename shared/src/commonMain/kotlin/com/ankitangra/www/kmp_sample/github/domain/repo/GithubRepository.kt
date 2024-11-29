package com.ankitangra.www.kmp_sample.github.domain.repo

import com.ankitangra.www.kmp_sample.github.domain.models.GithubDetail
import com.ankitangra.www.kmp_sample.github.domain.models.GithubList

interface GithubRepository {
    suspend fun getGithubList(): GithubList
    suspend fun getGithubDetails(): GithubDetail
}