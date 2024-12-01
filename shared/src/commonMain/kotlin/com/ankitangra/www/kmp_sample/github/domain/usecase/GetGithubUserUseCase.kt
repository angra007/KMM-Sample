package com.ankitangra.www.kmp_sample.github.domain.usecase

import com.ankitangra.www.kmp_sample.core.util.Either
import com.ankitangra.www.kmp_sample.github.domain.models.GithubSearchResult
import com.ankitangra.www.kmp_sample.github.domain.repo.GithubRepository

interface GetGithubUserUseCase: suspend (String) -> Either<List<GithubSearchResult>>

class GetGithubUserUseCaseImpl(
    private val repo: GithubRepository
): GetGithubUserUseCase {

    override suspend fun invoke(username: String): Either<List<GithubSearchResult>> = runCatching{
        val list = repo.getGithubUser(name = username)
        Either.Success(list)
    }.getOrElse {
        Either.Error(it.message ?: "Something Went Wrong")
    }

}