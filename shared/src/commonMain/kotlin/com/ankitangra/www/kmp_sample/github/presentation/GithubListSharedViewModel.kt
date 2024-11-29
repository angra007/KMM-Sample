package com.ankitangra.www.kmp_sample.github.presentation

import com.ankitangra.www.kmp_sample.core.util.ViewModel
import com.ankitangra.www.kmp_sample.github.domain.usecase.GetGithubListUseCase
import io.github.aakira.napier.Napier
import kotlinx.coroutines.launch

class GithubListSharedViewModel(
    private val githubListUseCase: GetGithubListUseCase
): ViewModel() {

    fun helloWorld() {
        coroutineScope.launch {
            val result = githubListUseCase("")
            Napier.d("Inside Shared Module")
        }
    }
}