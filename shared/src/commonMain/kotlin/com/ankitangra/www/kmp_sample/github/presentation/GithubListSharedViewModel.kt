package com.ankitangra.www.kmp_sample.github.presentation

import com.ankitangra.www.kmp_sample.core.communication.toCommonStateFlow
import com.ankitangra.www.kmp_sample.core.util.Either
import com.ankitangra.www.kmp_sample.core.util.ViewModel
import com.ankitangra.www.kmp_sample.github.domain.models.GithubSearchResult
import com.ankitangra.www.kmp_sample.github.domain.usecase.GithubSearchUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

open class GithubListSharedViewModel(
    private val searchUserUseCase: GithubSearchUseCase
): ViewModel() {

    private val _state = MutableStateFlow(GithubListSharedViewState())
    val state = _state.asStateFlow().toCommonStateFlow()

    fun searchUser(query: String) {
        coroutineScope.launch {
            _state.value = _state.value.copy(isLoading = true, errorMessage = null)

            val state = when (val result = searchUserUseCase(query)) {
                is Either.Error ->
                    GithubListSharedViewState(isLoading = false, errorMessage = result.message)

                is Either.Success ->
                    GithubListSharedViewState(isLoading = false, searchList = result.data)
            }

            _state.value = state
        }
    }

}


data class GithubListSharedViewState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val searchList: List<GithubSearchResult> = listOf()
) {
    companion object {
        fun initial() = GithubListSharedViewState()
    }
}
