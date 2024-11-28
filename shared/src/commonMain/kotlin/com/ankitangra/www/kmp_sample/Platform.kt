package com.ankitangra.www.kmp_sample

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform