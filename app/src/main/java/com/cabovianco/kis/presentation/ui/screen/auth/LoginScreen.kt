package com.cabovianco.kis.presentation.ui.screen.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cabovianco.kis.R
import com.cabovianco.kis.presentation.ui.screen.shared.AppPrimaryButton
import com.cabovianco.kis.presentation.ui.screen.shared.AppTextButton
import com.cabovianco.kis.presentation.ui.screen.shared.AppTextField

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier) {
        LoginContent(
            email = "",
            password = "",
            onEmailChange = {},
            onPasswordChange = {},
            onSignInClick = {},
            onRegisterClick = {},
            modifier = Modifier.padding(it)
        )
    }
}

@Composable
private fun LoginContent(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onSignInClick: () -> Unit = {},
    onRegisterClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterVertically)
    ) {
        Spacer(modifier = Modifier.weight(1f))

        AppIcon()
        Welcome()

        Spacer(modifier = Modifier.weight(0.25f))

        Form(
            email = email,
            onEmailChange = onEmailChange,
            password = password,
            onPasswordChange = onPasswordChange
        )

        Spacer(modifier = Modifier.weight(0.5f))

        SignInButton(onClick = onSignInClick)
        RegisterPrompt(onClick = onRegisterClick)

        Spacer(modifier = Modifier.weight(0.25f))
    }
}

@Composable
private fun AppIcon(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(128.dp),
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = null
        )
    }
}

@Composable
private fun Welcome(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.login_welcome),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSurface
        )

        Text(
            text = stringResource(R.string.login_subtitle),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun Form(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EmailTextField(email = email, onEmailChange = onEmailChange)
        PasswordTextField(password = password, onPasswordChange = onPasswordChange)
    }
}

@Composable
private fun EmailTextField(
    email: String,
    onEmailChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    AppTextField(
        modifier = modifier.fillMaxWidth(),
        value = email,
        onValueChange = onEmailChange,
        placeholder = stringResource(R.string.login_email_placeholder)
    )
}

@Composable
private fun PasswordTextField(
    password: String,
    onPasswordChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    AppTextField(
        modifier = modifier.fillMaxWidth(),
        value = password,
        onValueChange = onPasswordChange,
        placeholder = stringResource(R.string.login_password_placeholder)
    )
}

@Composable
private fun SignInButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    AppPrimaryButton(
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp)
            .padding(horizontal = 16.dp),
        text = stringResource(R.string.login_sign_in_button),
        onClick = onClick
    )
}

@Composable
private fun RegisterPrompt(onClick: () -> Unit, modifier: Modifier = Modifier) {
    AppTextButton(
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp)
            .padding(horizontal = 16.dp),
        text = stringResource(R.string.login_register_prompt),
        onClick = onClick
    )
}
