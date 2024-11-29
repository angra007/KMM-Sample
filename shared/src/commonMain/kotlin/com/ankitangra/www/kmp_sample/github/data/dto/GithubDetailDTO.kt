package com.ankitangra.www.kmp_sample.github.data.dto

import com.ankitangra.www.kmp_sample.github.domain.models.GithubDetail
import kotlinx.serialization.Serializable

@Serializable
data class GithubDetailDTO(
    val name: String
)

fun GithubDetailDTO.toGithubDetail(): GithubDetail  {
    return GithubDetail(
        name = name
    )
}