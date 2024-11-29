package com.ankitangra.www.kmp_sample.github.data.repo

import com.ankitangra.www.kmp_sample.core.data.remote.toApiResponse
import com.ankitangra.www.kmp_sample.core.data.util.NetworkResult
import com.ankitangra.www.kmp_sample.github.data.dto.GithubDetailDTO
import com.ankitangra.www.kmp_sample.github.data.dto.GithubListDTO
import com.ankitangra.www.kmp_sample.github.data.dto.toGithubDetail
import com.ankitangra.www.kmp_sample.github.data.dto.toGithubList
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
                val apiResponse = result.toApiResponse<GithubListDTO>(json)
                val githubDTO = apiResponse.data ?: throw Exception(apiResponse.message)
                return githubDTO.toGithubList()
            }
        }
    }

    override suspend fun getGithubDetails(): GithubDetail {
        return when (val result = api.getGithubDetail()) {
            is NetworkResult.Error -> throw result.error
            is NetworkResult.Success -> {
                val apiResponse = result.toApiResponse<GithubDetailDTO>(json)
                val githubDTO = apiResponse.data ?: throw Exception(apiResponse.message)
                return githubDTO.toGithubDetail()
            }
        }
    }

}