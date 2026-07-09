package com.cabovianco.kis.presentation.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cabovianco.kis.presentation.ui.screen.auth.LoginScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.Auth.Login,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        composable<Screen.Auth.Login> {
            LoginScreen()
        }

        composable<Screen.Auth.Register> {  }

        composable<Screen.Inbox> {  }

        composable<Screen.Compose> {  }
    }
}
