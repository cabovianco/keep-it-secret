package com.cabovianco.kis.presentation.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cabovianco.kis.presentation.ui.screen.InboxScreen
import com.cabovianco.kis.presentation.ui.screen.auth.LoginScreen
import com.cabovianco.kis.presentation.ui.screen.auth.RegisterScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.Inbox, //Screen.Auth.Login,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        composable<Screen.Auth.Login> {
            LoginScreen(onRegisterClick = { navController.navigate(Screen.Auth.Register) })
        }

        composable<Screen.Auth.Register> {
            RegisterScreen(onLoginClick = { navController.navigateUp() })
        }

        composable<Screen.Inbox> {
            InboxScreen(
                onAccountActionClick = { navController.navigate(Screen.Account) },
                onComposeSecretFloatingActionClick = { navController.navigate(Screen.Compose) }
            )
        }

        composable<Screen.Compose> { }

        composable<Screen.Account> { }
    }
}
