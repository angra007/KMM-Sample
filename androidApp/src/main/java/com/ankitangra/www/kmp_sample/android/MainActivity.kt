package com.ankitangra.www.kmp_sample.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ankitangra.www.kmp_sample.android.ui.presentation.github.detail.GithubDetailScreen
import com.ankitangra.www.kmp_sample.android.ui.presentation.github.list.GithubListScreen
import com.ankitangra.www.kmp_sample.android.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                AppBackground {
                    MainNavigation()
                }
            }
        }
    }
}

@Composable
fun AppBackground(
    content: @Composable BoxScope.() -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        content.invoke(this)
    }
}

@Composable
fun MainNavigation(
    navController: NavHostController = rememberNavController(),
    startDestination: String = "githubList",
) {
    NavHost(navController = navController, startDestination = startDestination) {

        composable(route = "githubList") {
            GithubListScreen { name ->
                navController.navigateToGithubDetail(name = name)
            }
        }

        composable(
            route = "githubDetail/{username}",
            arguments = listOf(navArgument("username") { type = NavType.StringType })
        ) { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username")
            username?.let{ name ->
                GithubDetailScreen(
                    name = name
                ) {
                    navController.navigateUp()
                }
            }
        }
    }
}

fun NavHostController.navigateToGithubDetail(
    name: String,
    navOptions: NavOptions? = null,
) {
    navigate(route = "githubDetail/$name", navOptions = navOptions)
}


