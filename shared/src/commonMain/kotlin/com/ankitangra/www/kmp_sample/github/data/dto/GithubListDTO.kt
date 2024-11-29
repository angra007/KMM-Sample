package com.ankitangra.www.kmp_sample.github.data.dto

import com.ankitangra.www.kmp_sample.github.domain.models.GithubList
import kotlinx.serialization.Serializable

@Serializable
data class GithubListDTO(
    val name: String
)

fun GithubListDTO.toGithubList(): GithubList {
    return GithubList(
        name = name
    )
}