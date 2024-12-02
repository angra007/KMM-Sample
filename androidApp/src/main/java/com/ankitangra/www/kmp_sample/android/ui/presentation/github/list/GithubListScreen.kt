package com.ankitangra.www.kmp_sample.android.ui.presentation.github.list

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
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
    var query by remember { mutableStateOf(TextFieldValue("")) }
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    ) {
        BasicTextField(
            value = query,
            onValueChange = { newValue ->
                query = newValue
                if (newValue.text.length >= 3) {
                    viewModel.search(newValue.text)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, MaterialTheme.colorScheme.primary, MaterialTheme.shapes.small)
                .padding(8.dp),
        )

        Spacer(modifier = Modifier.height(8.dp))

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }

        // Results List
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.result) { result ->
                SearchResultItem(result)
            }
        }
    }
}

@Composable
fun SearchResultItem(result: GithubSearchResult) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 8.dp),
    ) {
        Text(
            text = result.name,
            modifier = Modifier.padding(16.dp)
        )
    }
}