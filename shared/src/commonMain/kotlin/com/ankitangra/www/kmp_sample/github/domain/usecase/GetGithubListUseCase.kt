package com.ankitangra.www.kmp_sample.github.domain.usecase

import com.ankitangra.www.kmp_sample.core.util.Either
import com.ankitangra.www.kmp_sample.github.domain.repo.GithubRepository
import kotlinx.coroutines.delay

interface GetGithubListUseCase: suspend (String) -> Either<Unit>

class GetGithubListUseCaseImpl(
    private val repo: GithubRepository
): GetGithubListUseCase {

    override suspend fun invoke(s: String): Either<Unit> = runCatching{
        repo.getGithubList()
        delay(5000)
        Either.Success(Unit)
    }.getOrElse {
        Either.Error("")
    }

}