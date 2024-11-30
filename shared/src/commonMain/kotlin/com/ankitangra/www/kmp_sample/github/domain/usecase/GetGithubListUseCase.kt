package com.ankitangra.www.kmp_sample.github.domain.usecase

import com.ankitangra.www.kmp_sample.core.util.Either
import com.ankitangra.www.kmp_sample.github.domain.models.GithubList
import com.ankitangra.www.kmp_sample.github.domain.repo.GithubRepository

interface GetGithubListUseCase: suspend (String) -> Either<GithubList>

class GetGithubListUseCaseImpl(
    private val repo: GithubRepository
): GetGithubListUseCase {

    override suspend fun invoke(s: String): Either<GithubList> = runCatching{
        val list = repo.getGithubList()
        Either.Success(list)
    }.getOrElse {
        Either.Error(it.message ?: "Something Went Wrong")
    }

}