package com.ankitangra.www.kmp_sample.android.ui.presentation.github.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ankitangra.www.kmp_sample.core.communication.toCommonFlow
import com.ankitangra.www.kmp_sample.core.communication.toCommonStateFlow
import com.ankitangra.www.kmp_sample.github.presentation.GithubListSharedViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch

class GithubListViewModel(
    private val sharedViewModel: GithubListSharedViewModel
): ViewModel() {


    private val _event = Channel<GithubListEvents>()
    val event =
        _event.receiveAsFlow().shareIn(CoroutineScope(Dispatchers.Main), SharingStarted.Lazily)
            .toCommonFlow()

    private val _state = MutableStateFlow(GithubListViewState())
    val state = _state.asStateFlow().toCommonStateFlow()

    init {
        viewModelScope.launch {
            sharedViewModel.state
                .map { state ->
                    GithubListViewState(state.isLoading, state.searchList.map {
                        GithubSearchResult(name = it.name)
                    })
                }
                .collect { newState ->
                    _state.value = newState
                }
        }
    }

    fun search(query: String) {
        sharedViewModel.searchUser(query = query)
    }
}

sealed class GithubListEvents(

)

data class GithubListViewState(
    val isLoading: Boolean = false,
    val result: List<GithubSearchResult> = listOf()
)

data class GithubSearchResult ( val name: String)




