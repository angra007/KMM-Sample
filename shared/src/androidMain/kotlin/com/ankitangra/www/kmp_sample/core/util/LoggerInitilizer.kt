package com.ankitangra.www.kmp_sample.core.util

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

actual fun initializeLogger(){
    Napier.base(DebugAntilog())
}