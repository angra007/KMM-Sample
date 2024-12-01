package com.ankitangra.www.kmp_sample.github.data.dto

import com.ankitangra.www.kmp_sample.github.domain.models.GithubSearchResult
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubSearchDTO(
    @SerialName("name") val name: String,
    @SerialName("public_repos") val publicRepos: Int,
    @SerialName("avatar_url") val avatarUrl: String
)

fun GithubSearchDTO.toSearchResult(): GithubSearchResult {
    return GithubSearchResult(
        name = name,
        profileImage = avatarUrl,
        numberOfRepo = publicRepos
    )
}