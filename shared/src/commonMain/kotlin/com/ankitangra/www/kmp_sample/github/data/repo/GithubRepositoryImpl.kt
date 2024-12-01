package com.ankitangra.www.kmp_sample.github.data.repo

import com.ankitangra.www.kmp_sample.core.data.util.NetworkResult
import com.ankitangra.www.kmp_sample.core.data.util.toObject
import com.ankitangra.www.kmp_sample.github.data.dto.GithubSearchDTO
import com.ankitangra.www.kmp_sample.github.data.dto.toSearchResult
import com.ankitangra.www.kmp_sample.github.data.remote.GithubApi
import com.ankitangra.www.kmp_sample.github.domain.models.GithubSearchResult
import com.ankitangra.www.kmp_sample.github.domain.repo.GithubRepository
import kotlinx.serialization.json.Json

class GithubRepositoryImpl(
    private val api: GithubApi,
    private val json: Json
): GithubRepository {

    override suspend fun getGithubUser(user: String): List<GithubSearchResult> {
        return when (val result = api.getGithubUser(user)) {
            is NetworkResult.Error -> throw result.error

            is NetworkResult.Success -> {
                val apiResponse = json.toObject<GithubSearchDTO>(result.data.decodeToString())
                val searchResult = apiResponse.toSearchResult()
                return listOf(searchResult)
            }
        }
    }

    override suspend fun getGithubOrgs(org: String): List<GithubSearchResult> {
        return when (val result = api.getGithubOrg(org)) {
            is NetworkResult.Error -> throw result.error

            is NetworkResult.Success -> {
                val apiResponse = json.toObject<GithubSearchDTO>(result.data.decodeToString())
                val searchResult = apiResponse.toSearchResult()
                return listOf(searchResult)
            }
        }
    }

}