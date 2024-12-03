package com.ankitangra.www.kmp_sample.github.presentation

import com.ankitangra.www.kmp_sample.core.communication.toCommonStateFlow
import com.ankitangra.www.kmp_sample.core.util.Either
import com.ankitangra.www.kmp_sample.core.util.ViewModel
import com.ankitangra.www.kmp_sample.github.domain.models.GithubUser
import com.ankitangra.www.kmp_sample.github.domain.usecase.GetGithubUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GithubDetailSharedViewModel(
    private val githubUserUseCase: GetGithubUserUseCase
): ViewModel() {

    private val _state = MutableStateFlow(GithubDetailViewState())
    val state = _state.asStateFlow().toCommonStateFlow()

    fun getGithubUser(name: String) {
        coroutineScope.launch {
            _state.value = _state.value.copy(isLoading = true, errorMessage = null)

            val newState = when (val result = githubUserUseCase(name)) {
                is Either.Error ->
                    GithubDetailViewState(isLoading = false, errorMessage = result.message)

                is Either.Success ->
                    GithubDetailViewState(isLoading = false, githubUser = result.data)
            }

            _state.value = newState
        }
    }
}

data class GithubDetailViewState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val githubUser: GithubUser? = null
)