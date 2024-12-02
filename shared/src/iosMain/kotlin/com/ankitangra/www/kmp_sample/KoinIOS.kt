package com.ankitangra.www.kmp_sample

import com.ankitangra.www.kmp_sample.github.presentation.GithubDetailSharedViewModel
import com.ankitangra.www.kmp_sample.github.presentation.GithubListSharedViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.KoinApplication
import org.koin.core.component.KoinComponent
import org.koin.dsl.module

fun initKoinIos(): KoinApplication = initKoin(
    module {
    }
)

actual val platformModule = module {
    single<HttpClient> {
        HttpClient(Darwin) {

            engine {
                configureRequest {
                    setAllowsCellularAccess(true)
                }
            }

            install(ContentNegotiation) {
                json(get<Json>())
            }

            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }
        }
    }

    factory {
        GithubListSharedViewModel(get(), get())
    }

    factory {
        GithubDetailSharedViewModel()
    }

}

object SharedViewModelProvider: KoinComponent {

    fun getGithubListSharedViewModel() = getKoin().get<GithubListSharedViewModel>()
    fun getGithubDetailSharedViewModel() = getKoin().get<GithubDetailSharedViewModel>()
}
