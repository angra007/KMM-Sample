package com.ankitangra.www.kmp_sample.github.domain.usecase

import com.ankitangra.www.kmp_sample.core.util.Either
import com.ankitangra.www.kmp_sample.github.domain.repo.GithubRepository

interface GetGithubListUseCase: suspend (String) -> Either<Unit>

class GetGithubListUseCaseImpl(
    private val repo: GithubRepository
): GetGithubListUseCase {

    override suspend fun invoke(s: String): Either<Unit> = runCatching{
        repo.getGithubList()
        Either.Success(Unit)
    }.getOrElse {
        Either.Error("")
    }

}