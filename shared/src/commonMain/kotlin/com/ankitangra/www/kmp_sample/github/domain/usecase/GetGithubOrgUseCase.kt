package com.ankitangra.www.kmp_sample.github.domain.usecase

import com.ankitangra.www.kmp_sample.core.util.Either
import com.ankitangra.www.kmp_sample.github.domain.models.GithubSearchResult
import com.ankitangra.www.kmp_sample.github.domain.repo.GithubRepository

interface GetGithubOrgUseCase: suspend (String) -> Either<List<GithubSearchResult>>

class GetGithubOrgUseCaseImpl(
    private val repo: GithubRepository
): GetGithubOrgUseCase {

    override suspend fun invoke(username: String): Either<List<GithubSearchResult>> = runCatching{
        val list = repo.getGithubOrgs(name = username)
        Either.Success(list)
    }.getOrElse {
        Either.Error(it.message ?: "Something Went Wrong")
    }

}