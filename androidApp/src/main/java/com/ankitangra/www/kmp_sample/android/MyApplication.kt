package com.ankitangra.www.kmp_sample.android

import android.app.Application
import android.content.Context
import com.ankitangra.www.kmp_sample.android.ui.presentation.github.detail.GithubDetailViewModel
import com.ankitangra.www.kmp_sample.android.ui.presentation.github.list.GithubListViewModel
import com.ankitangra.www.kmp_sample.core.util.initializeLogger
import com.ankitangra.www.kmp_sample.initKoin
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin(module {
            single<Context> { this@MyApplication }

            viewModel {
                GithubListViewModel(get())
            }

            viewModel {
                GithubDetailViewModel(get())
            }

        })
        initializeLogger()
    }
}
