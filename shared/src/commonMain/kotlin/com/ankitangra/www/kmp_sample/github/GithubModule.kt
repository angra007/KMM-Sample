package com.ankitangra.www.kmp_sample.github

import com.ankitangra.www.kmp_sample.github.data.remote.GithubApi
import com.ankitangra.www.kmp_sample.github.data.remote.GithubApiImpl
import com.ankitangra.www.kmp_sample.github.data.repo.GithubRepositoryImpl
import com.ankitangra.www.kmp_sample.github.domain.repo.GithubRepository
import com.ankitangra.www.kmp_sample.github.domain.usecase.GetGithubDetailUseCase
import com.ankitangra.www.kmp_sample.github.domain.usecase.GetGithubDetailUseCaseImpl
import com.ankitangra.www.kmp_sample.github.domain.usecase.GetGithubListUseCase
import com.ankitangra.www.kmp_sample.github.domain.usecase.GetGithubListUseCaseImpl
import org.koin.dsl.module

val githubModule = module {

    single<GithubApi> {
        GithubApiImpl(get())
    }

    single<GithubRepository> {
        GithubRepositoryImpl(get(), get())
    }

    single<GetGithubListUseCase> {
        GetGithubListUseCaseImpl(get())
    }

    single<GetGithubDetailUseCase> {
        GetGithubDetailUseCaseImpl(get())
    }

}