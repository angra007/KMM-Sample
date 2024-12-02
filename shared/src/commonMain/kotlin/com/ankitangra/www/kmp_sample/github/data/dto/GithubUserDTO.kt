package com.ankitangra.www.kmp_sample.github.data.dto

import com.ankitangra.www.kmp_sample.github.domain.models.GithubUser
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubUserDTO(
    @SerialName("name") val name: String,
    @SerialName("public_repos") val publicRepos: Int,
    @SerialName("avatar_url") val avatarUrl: String
)

fun GithubUserDTO.toGithubUser(): GithubUser {
    return GithubUser(
        name = name,
        profileImage = avatarUrl,
        numberOfRepo = publicRepos
    )
}