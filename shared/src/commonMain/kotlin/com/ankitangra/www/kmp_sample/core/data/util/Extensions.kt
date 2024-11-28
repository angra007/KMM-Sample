package com.ankitangra.www.kmp_sample.core.data.util

import kotlinx.serialization.json.Json

inline fun <reified T> Json.toObject(value: String): T =
    run { this.decodeFromString(value) }