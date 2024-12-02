package com.ankitangra.www.kmp_sample.github.domain.usecase

import com.ankitangra.www.kmp_sample.core.util.Either
import com.ankitangra.www.kmp_sample.github.domain.models.GithubSearchResult
import com.ankitangra.www.kmp_sample.github.domain.repo.GithubRepository

interface GithubSearchUseCase: suspend (String) -> Either<List<GithubSearchResult>>

class GithubSearchUseCaseImpl(
    private val repo: GithubRepository
): GithubSearchUseCase {
    override suspend fun invoke(query: String): Either<List<GithubSearchResult>> = runCatching {
        val list = repo.searchUser(query = query)
        Either.Success(list)
    }.getOrElse {
        Either.Error(it.message ?: "Something Went Wrong")
    }
}