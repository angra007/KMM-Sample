package com.ankitangra.www.kmp_sample

import com.ankitangra.www.kmp_sample.core.data.remote.KmmAppKtorClient
import com.ankitangra.www.kmp_sample.github.githubModule
import kotlinx.serialization.json.Json
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

fun initKoin(
    appModule: Module
): KoinApplication {
    val koinApplication = startKoin {
        modules(
            appModule,
            platformModule,
            githubModule,
            coreModule
        )
    }
    return koinApplication
}

private val coreModule = module {

    single {
        Json {
            isLenient = true
            prettyPrint = true
            ignoreUnknownKeys = true
        }
    }

    single {
        KmmAppKtorClient(get())
    }
}

expect val platformModule: Module