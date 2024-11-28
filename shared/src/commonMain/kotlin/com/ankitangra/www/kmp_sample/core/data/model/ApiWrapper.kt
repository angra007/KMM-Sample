package com.ankitangra.www.kmp_sample.core.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiWrapper<T>(
    val message: String? = null,
    val data: T? = null,
    val status: Boolean? = null
)
