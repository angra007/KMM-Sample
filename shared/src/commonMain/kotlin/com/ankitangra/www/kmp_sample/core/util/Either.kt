package com.ankitangra.www.kmp_sample.core.util

sealed interface Either<out T : Any> {
    data class Success<out T : Any>(val data: T) : Either<T>
    data class Error<out T : Any>(val message: String) : Either<T>
}