package com.ankitangra.www.kmp_sample.android.ui.presentation.github.list

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import org.koin.androidx.compose.koinViewModel

@Composable
fun GithubListScreen(
    viewModel: GithubListViewModel = koinViewModel()
){

    LaunchedEffect(key1 = Unit) {
        viewModel.state.collect {
            Log.d("Ankit", "New State: $it")
        }
    }


    Column {
        Text(text = "Hello World")

        Button(onClick = {
            viewModel.helloWorld()
        }) {
            Text(text = "Click Me!!")
        }
    }
}