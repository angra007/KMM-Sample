package com.ankitangra.www.kmp_sample.android

import android.app.Application
import com.ankitangra.www.kmp_sample.initKoin
import org.koin.dsl.module

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin(module { })
    }
}
