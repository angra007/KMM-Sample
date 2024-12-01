package com.ankitangra.www.kmp_sample.github

import com.ankitangra.www.kmp_sample.github.data.remote.GithubApi
import com.ankitangra.www.kmp_sample.github.data.remote.GithubApiImpl
import com.ankitangra.www.kmp_sample.github.data.repo.GithubRepositoryImpl
import com.ankitangra.www.kmp_sample.github.domain.repo.GithubRepository
import com.ankitangra.www.kmp_sample.github.domain.usecase.GetGithubOrgUseCase
import com.ankitangra.www.kmp_sample.github.domain.usecase.GetGithubOrgUseCaseImpl
import com.ankitangra.www.kmp_sample.github.domain.usecase.GetGithubUserUseCase
import com.ankitangra.www.kmp_sample.github.domain.usecase.GetGithubUserUseCaseImpl
import org.koin.dsl.module

val githubModule = module {

    single<GithubApi> {
        GithubApiImpl(get())
    }

    single<GithubRepository> {
        GithubRepositoryImpl(get(), get())
    }

    single<GetGithubUserUseCase> {
        GetGithubUserUseCaseImpl(get())
    }

    single<GetGithubOrgUseCase> {
        GetGithubOrgUseCaseImpl(get())
    }

}