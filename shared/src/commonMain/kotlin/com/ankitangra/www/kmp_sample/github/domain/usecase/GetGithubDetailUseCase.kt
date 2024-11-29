package com.ankitangra.www.kmp_sample.github.domain.usecase

import com.ankitangra.www.kmp_sample.core.util.Either
import com.ankitangra.www.kmp_sample.github.domain.repo.GithubRepository

interface GetGithubDetailUseCase: suspend (String) -> Either<Unit>

class GetGithubDetailUseCaseImpl(
    private val repo: GithubRepository
): GetGithubDetailUseCase {

    override suspend fun invoke(s: String): Either<Unit> = runCatching{
        repo.getGithubDetails()
        Either.Success(Unit)
    }.getOrElse {
        Either.Error("")
    }

}