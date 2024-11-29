package com.ankitangra.www.kmp_sample.core.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

actual abstract class ViewModel actual constructor() : ViewModel() {

    actual val coroutineScope = viewModelScope
}