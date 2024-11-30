package com.ankitangra.www.kmp_sample.github.presentation

import com.ankitangra.www.kmp_sample.core.communication.toCommonStateFlow
import com.ankitangra.www.kmp_sample.core.util.Either
import com.ankitangra.www.kmp_sample.core.util.ViewModel
import com.ankitangra.www.kmp_sample.github.domain.models.GithubList
import com.ankitangra.www.kmp_sample.github.domain.usecase.GetGithubListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

open class GithubListSharedViewModel(
    private val githubListUseCase: GetGithubListUseCase
): ViewModel() {

    private val _state = MutableStateFlow(GithubListSharedViewState())
    val state = _state.asStateFlow().toCommonStateFlow()

    fun getGithubList() {

        coroutineScope.launch {
            _state.value = _state.value.copy(isLoading = true, errorMessage = null)

            val newState = when (val result = githubListUseCase("")) {
                is Either.Error ->
                    GithubListSharedViewState(isLoading = false, errorMessage = result.message)

                is Either.Success ->
                    GithubListSharedViewState(isLoading = false, list = result.data)
            }

            _state.value = newState
        }

    }

}

data class GithubListSharedViewState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val list: GithubList = GithubList("")
) {
    companion object {
        fun initial() = GithubListSharedViewState()
    }
}
