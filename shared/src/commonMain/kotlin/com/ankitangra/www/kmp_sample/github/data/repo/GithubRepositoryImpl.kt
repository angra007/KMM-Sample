package com.ankitangra.www.kmp_sample.github.data.repo

import com.ankitangra.www.kmp_sample.core.data.model.NetworkResult
import com.ankitangra.www.kmp_sample.github.data.remote.GithubApi
import com.ankitangra.www.kmp_sample.github.domain.models.GithubDetail
import com.ankitangra.www.kmp_sample.github.domain.models.GithubList
import com.ankitangra.www.kmp_sample.github.domain.repo.GithubRepository
import io.github.aakira.napier.Napier
import kotlinx.serialization.json.Json

class GithubRepositoryImpl(
    private val api: GithubApi,
    private val json: Json
): GithubRepository {

    override suspend fun getGithubList(): GithubList {
        return when (val result = api.getGithubList()) {
            is NetworkResult.Error -> throw result.error
            is NetworkResult.Success -> {
                Napier.d(message = "Github List API Call Success",tag = "Ankit")
                return GithubList("")
            }
        }
    }

    override suspend fun getGithubDetails(): GithubDetail {
        return when (val result = api.getGithubDetail()) {
            is NetworkResult.Error -> throw result.error
            is NetworkResult.Success -> {
                return GithubDetail("")
            }
        }
    }

}