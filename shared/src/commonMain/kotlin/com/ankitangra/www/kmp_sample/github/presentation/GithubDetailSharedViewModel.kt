package com.ankitangra.www.kmp_sample.github.presentation

import com.ankitangra.www.kmp_sample.core.communication.toCommonStateFlow
import com.ankitangra.www.kmp_sample.core.util.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class GithubDetailSharedViewModel: ViewModel() {

    private val _state = MutableStateFlow(GithubDetailViewState())
    val state = _state.asStateFlow().toCommonStateFlow()

}

data class GithubDetailViewState(
    val isLoading: Boolean = false
)