package com.ankitangra.www.kmp_sample.github.presentation

import com.ankitangra.www.kmp_sample.core.communication.toCommonStateFlow
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
        _state.value = _state.value.copy(isLoading = true)
        coroutineScope.launch {
            githubListUseCase("")
            _state.value = _state.value.copy(list = GithubList("Ankit"),isLoading = false)
        }
    }

}

data class GithubListSharedViewState(
    val isLoading: Boolean = false,
    val list: GithubList = GithubList("")
) {
    companion object {
        fun initial() = GithubListSharedViewState()
    }
}
