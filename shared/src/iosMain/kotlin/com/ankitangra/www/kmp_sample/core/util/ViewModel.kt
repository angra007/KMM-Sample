package com.ankitangra.www.kmp_sample.core.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

actual abstract class ViewModel actual constructor() {

    actual val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
}