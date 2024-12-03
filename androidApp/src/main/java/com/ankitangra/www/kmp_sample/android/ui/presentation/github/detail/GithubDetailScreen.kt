package com.ankitangra.www.kmp_sample.android.ui.presentation.github.detail

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ankitangra.www.kmp_sample.android.R
import org.koin.androidx.compose.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GithubDetailScreen(
    viewModel: GithubDetailViewModel = koinViewModel(),
    name: String,
    onBackClicked: () -> Unit
) {

    val state by viewModel.state.collectAsState()
    LaunchedEffect(key1 = Unit) {
        viewModel.getGithubUser(user = name)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = name, color = Color.White)
                },
                navigationIcon = {
                    IconButton(onClick = { onBackClicked.invoke() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
                            contentDescription = "Back Button",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                ),
            )
        }
    ) { paddingValues ->

        Row(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = state.user?.profileImage.orEmpty(),
                contentDescription = "User Avatar",
                modifier = Modifier
                    .size(80.dp)
                    .border(1.dp, Color.Gray)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = state.user?.name.orEmpty(),
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "${state.user?.numberOfRepository} Repositories",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}


