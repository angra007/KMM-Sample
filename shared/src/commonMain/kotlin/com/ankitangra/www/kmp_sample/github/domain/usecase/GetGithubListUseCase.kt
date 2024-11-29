package com.ankitangra.www.kmp_sample.github.domain.usecase

import com.ankitangra.www.kmp_sample.core.util.Either

interface GetGithubListUseCase: suspend (String) -> Either<Unit>

class GetGithubListUseCaseImpl: GetGithubListUseCase {

    override suspend fun invoke(s: String): Either<Unit> = runCatching{
        Either.Success(Unit)
    }.getOrElse {
        Either.Error("")
    }

}