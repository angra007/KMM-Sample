package com.ankitangra.www.kmp_sample.github.presentation

import com.ankitangra.www.kmp_sample.core.util.ViewModel
import com.ankitangra.www.kmp_sample.github.domain.usecase.GetGithubDetailUseCase

class GithubDetailSharedViewModel(
    private val githubDetailUseCase: GetGithubDetailUseCase
): ViewModel() {

}