package com.ankitangra.www.kmp_sample.core.util

import kotlinx.coroutines.CoroutineScope

expect abstract class ViewModel() {

    val coroutineScope: CoroutineScope

}