package com.cabovianco.kis.presentation.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.cabovianco.kis.R
import com.cabovianco.kis.presentation.ui.screen.shared.AppMenu
import com.cabovianco.kis.presentation.ui.screen.shared.Menu
import com.cabovianco.kis.presentation.ui.screen.shared.MenuItem

@Composable
fun SettingsScreen(
    onNavBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = { TopBar(onNavBack = onNavBack) }
    ) {
        SettingsContent(modifier = Modifier.padding(it))
    }
}

@Composable
private fun SettingsContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AccountMenu()
    }
}

@Composable
private fun AccountMenu(modifier: Modifier = Modifier) {
    AppMenu(
        modifier = modifier,
        menu = Menu(
            title = stringResource(R.string.settings_account_menu_title),
            items = listOf(
                notificationMenuOption { },
                logoutMenuOption { },
                deleteAccountMenuOption { }
            )
        )
    )
}

@Composable
private fun notificationMenuOption(onClick: () -> Unit): MenuItem {
    return MenuItem(
        title = stringResource(R.string.settings_account_menu_notification_option),
        onClick = onClick,
        leadingContent = {
            Icon(
                painter = painterResource(R.drawable.notification),
                contentDescription = null
            )
        }
    )
}

@Composable
private fun logoutMenuOption(onClick: () -> Unit): MenuItem {
    return MenuItem(
        title = stringResource(R.string.settings_account_menu_logout_option),
        onClick = onClick,
        leadingContent = {
            Icon(
                painter = painterResource(R.drawable.log_out),
                contentDescription = null
            )
        }
    )
}

@Composable
private fun deleteAccountMenuOption(onClick: () -> Unit): MenuItem {
    return MenuItem(
        title = stringResource(R.string.settings_account_menu_delete_option),
        onClick = onClick,
        leadingContent = {
            Icon(
                painter = painterResource(R.drawable.delete),
                contentDescription = null
            )
        },
        enabled = false
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(onNavBack: () -> Unit, modifier: Modifier = Modifier) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = stringResource(R.string.settings_title),
                style = MaterialTheme.typography.titleLarge
            )
        },
        navigationIcon = {
            IconButton(
                onClick = onNavBack
            ) {
                Icon(
                    painter = painterResource(R.drawable.arrow_left),
                    contentDescription = null
                )
            }
        }
    )
}
