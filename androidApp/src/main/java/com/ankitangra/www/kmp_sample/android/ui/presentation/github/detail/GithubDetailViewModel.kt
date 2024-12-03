package com.ankitangra.www.kmp_sample.android.ui.presentation.github.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ankitangra.www.kmp_sample.core.communication.toCommonFlow
import com.ankitangra.www.kmp_sample.core.communication.toCommonStateFlow
import com.ankitangra.www.kmp_sample.github.presentation.GithubDetailSharedViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch

class GithubDetailViewModel(
    private val sharedViewModel: GithubDetailSharedViewModel
): ViewModel() {

    private val _event = Channel<GithubDetailEvents>()
    val event =
        _event.receiveAsFlow().shareIn(CoroutineScope(Dispatchers.Main), SharingStarted.Lazily)
            .toCommonFlow()

    private val _state = MutableStateFlow(GithubDetailState())
    val state = _state.asStateFlow().toCommonStateFlow()

    init {
        viewModelScope.launch {
            sharedViewModel.state
                .collect { newState ->
                    val state = GithubDetailState(
                        isLoading = newState.isLoading,
                        user = GithubUser(
                            name = newState.githubUser?.name.orEmpty(),
                            profileImage = newState.githubUser?.profileImage.orEmpty(),
                            numberOfRepository = newState.githubUser?.numberOfRepo ?: 0
                        )
                    )
                    _state.value = state
                }
        }
    }

    fun getGithubUser(user: String) {
        sharedViewModel.getGithubUser(user)
    }

}

sealed class GithubDetailEvents(

)

data class GithubDetailState(
    val isLoading: Boolean = false,
    val user: GithubUser? = null
)

data class GithubUser(
    val name: String,
    val profileImage: String,
    val numberOfRepository: Int
)