package com.ankitangra.www.kmp_sample.android.ui.presentation.github.list

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.koin.androidx.compose.koinViewModel

@Composable
fun GithubListScreen(
    viewModel: GithubListViewModel = koinViewModel()
){
    Column {
        Text(text = "Hello World")

        Button(onClick = {
            viewModel.helloWorld()
        }) {
            Text(text = "Click Me!!")
        }
    }
}