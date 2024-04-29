package com.archipelago.jobbsyy.root.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.archipelago.jobbsyy.arch.collectState
import com.archipelago.jobbsyy.root.mvi.HomeComponent

@Composable
fun HomeScreen(
    homeComponent: HomeComponent
) {
    val state by homeComponent.collectState()//TODO

    HomeScreenContent()
}

@Composable
private fun HomeScreenContent() {
    Column(modifier = Modifier.fillMaxSize().windowInsetsPadding(WindowInsets.safeDrawing)) {
        Text(text = "Home prikol")
    }
}
