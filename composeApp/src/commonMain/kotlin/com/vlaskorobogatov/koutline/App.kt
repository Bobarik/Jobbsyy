package com.vlaskorobogatov.koutline

import androidx.compose.runtime.Composable
import com.vlaskorobogatov.koutline.root.mvi.RootComponentImpl
import com.vlaskorobogatov.koutline.root.ui.RootScreen
import com.vlaskorobogatov.koutline.theme.AppTheme

@Composable
internal fun App(
    rootComponent: RootComponentImpl,
) = AppTheme {
    RootScreen(rootComponent)
}
