package com.ankitangra.www.kmp_sample.github.data.dto

import com.ankitangra.www.kmp_sample.github.domain.models.GithubSearchResult
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubSearchResultDTO(
    @SerialName("avatar_url") val avatarUrl: String,
    @SerialName("login") val name: String
)

fun GithubSearchResultDTO.toSearchResult(): GithubSearchResult {
    return GithubSearchResult(
        name = name,
        profileImage = avatarUrl
    )
}