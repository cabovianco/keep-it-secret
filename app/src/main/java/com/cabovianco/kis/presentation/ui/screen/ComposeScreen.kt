package com.cabovianco.kis.presentation.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
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
import com.cabovianco.kis.presentation.ui.screen.shared.AppPrimaryButton
import com.cabovianco.kis.presentation.ui.screen.shared.AppTextField
import com.cabovianco.kis.presentation.ui.screen.shared.UsernameTextField

@Composable
fun ComposeScreen(
    onNavBack: () -> Unit,
    onComposeAndSendClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = { TopBar(onNavBack = onNavBack) },
        bottomBar = { ComposeAndSendSecretButton(onClick = onComposeAndSendClick) }
    ) {
        ComposeContent(
            modifier = Modifier
                .padding(it)
                .padding(16.dp),
            username = "",
            content = "",
            onUsernameChange = {},
            onContentChange = {}
        )
    }
}

@Composable
private fun ComposeContent(
    username: String,
    content: String,
    onUsernameChange: (String) -> Unit,
    onContentChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        UsernameTextField(
            modifier = Modifier.fillMaxWidth(),
            username = username,
            onUsernameChange = onUsernameChange
        )

        ContentTextField(
            modifier = Modifier.fillMaxWidth(),
            content = content,
            onContentChange = onContentChange
        )
    }
}

@Composable
private fun ContentTextField(
    content: String,
    onContentChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val lines = 10

    AppTextField(
        modifier = modifier.fillMaxWidth(),
        value = content,
        onValueChange = onContentChange,
        placeholder = stringResource(R.string.compose_secret_content_placeholder),
        singleLine = false,
        maxLines = lines,
        minLines = lines
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(onNavBack: () -> Unit, modifier: Modifier = Modifier) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = stringResource(R.string.compose_title),
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

@Composable
private fun ComposeAndSendSecretButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    AppPrimaryButton(
        modifier = modifier
            .fillMaxWidth()
            .windowInsetsPadding(WindowInsets.navigationBars)
            .padding(16.dp)
            .height(64.dp),
        text = stringResource(R.string.compose_send_secret_button),
        onClick = onClick
    )
}
