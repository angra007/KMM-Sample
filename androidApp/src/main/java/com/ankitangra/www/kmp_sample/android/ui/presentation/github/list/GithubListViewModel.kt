package com.ankitangra.www.kmp_sample.android.ui.presentation.github.list

import android.util.Log
import androidx.lifecycle.ViewModel
import com.ankitangra.www.kmp_sample.list.presentation.GithubListSharedViewModel

class GithubListViewModel(
    private val sharedViewModel: GithubListSharedViewModel
): ViewModel() {

    fun helloWorld() {
        sharedViewModel.helloWorld()
    }

}