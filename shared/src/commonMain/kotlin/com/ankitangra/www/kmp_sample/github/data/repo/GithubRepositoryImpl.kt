package com.ankitangra.www.kmp_sample.github.data.repo

import com.ankitangra.www.kmp_sample.core.data.remote.toApiResponse
import com.ankitangra.www.kmp_sample.core.data.util.NetworkResult
import com.ankitangra.www.kmp_sample.core.data.util.toObject
import com.ankitangra.www.kmp_sample.github.data.dto.GithubSearchResultDTO
import com.ankitangra.www.kmp_sample.github.data.dto.GithubUserDTO
import com.ankitangra.www.kmp_sample.github.data.dto.toGithubUser
import com.ankitangra.www.kmp_sample.github.data.dto.toSearchResult
import com.ankitangra.www.kmp_sample.github.data.remote.GithubApi
import com.ankitangra.www.kmp_sample.github.domain.models.GithubSearchResult
import com.ankitangra.www.kmp_sample.github.domain.models.GithubUser
import com.ankitangra.www.kmp_sample.github.domain.repo.GithubRepository
import kotlinx.serialization.json.Json

class GithubRepositoryImpl(
    private val api: GithubApi,
    private val json: Json
): GithubRepository {

    override suspend fun getGithubUser(user: String): GithubUser {
        return when (val result = api.getGithubUser(user)) {
            is NetworkResult.Error -> throw result.error

            is NetworkResult.Success -> {
                val apiResponse = json.toObject<GithubUserDTO>(result.data.decodeToString())
                return apiResponse.toGithubUser()
            }
        }
    }

    override suspend fun searchUser(query: String): List<GithubSearchResult> {
        return when (val result = api.searchGithubOrg(query)) {
            is NetworkResult.Error -> throw result.error

            is NetworkResult.Success -> {
                val apiResponse = result.toApiResponse<GithubSearchResultDTO>(json)
                return apiResponse.items?.map {
                    it.toSearchResult()
                } ?: emptyList()
            }
        }
    }

}