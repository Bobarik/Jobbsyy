package com.vlaskorobogatov.koutline.root.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.vlaskorobogatov.koutline.arch.collectState
import com.vlaskorobogatov.koutline.root.mvi.RootComponent

@Composable
fun RootScreen(
    rootComponent: RootComponent
) {

    val state by rootComponent.collectState()

    Column(modifier = Modifier.fillMaxSize().windowInsetsPadding(WindowInsets.safeDrawing)) {

        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Login",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(16.dp)
            )
        }

        OutlinedTextField(
            value = state.login,
            onValueChange = rootComponent::onLoginChanged,
            label = { Text("Email") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )

        OutlinedTextField(
            value = state.password,
            onValueChange = rootComponent::onPasswordChanged,
            label = { Text("Password") },
            singleLine = true,
            visualTransformation = if (state.isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            trailingIcon = {
                IconButton(onClick = rootComponent::onPasswordVisibilityChanged) {
                    val imageVector = if (state.isPasswordVisible) Icons.Default.Close else Icons.Default.Edit
                    Icon(
                        imageVector,
                        contentDescription = if (state.isPasswordVisible) "Hide password" else "Show password"
                    )
                }
            }
        )

        Button(
            onClick = { /* Handle login logic here */ },
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Text("Login")
        }

        TextButton(
            onClick = { },
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Text("Open github")
        }
    }
}
