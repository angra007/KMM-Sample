package com.ankitangra.www.kmp_sample.github

import com.ankitangra.www.kmp_sample.github.domain.usecase.GetGithubListUseCase
import com.ankitangra.www.kmp_sample.github.domain.usecase.GetGithubListUseCaseImpl
import org.koin.dsl.module

val githubModule = module {

    single<GetGithubListUseCase> {
        GetGithubListUseCaseImpl()
    }
}