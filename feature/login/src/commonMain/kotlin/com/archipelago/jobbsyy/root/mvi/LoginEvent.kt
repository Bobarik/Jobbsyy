package com.archipelago.jobbsyy.root.mvi

import com.archipelago.jobbsyy.arch.BaseEvent

sealed interface LoginEvent : BaseEvent {
    data class OnLoginChanged(val login: String) : LoginEvent
    data class OnPasswordChanged(val password: String) : LoginEvent
    data object OnPasswordVisibilityChanged : LoginEvent
    data object OnHomeNavigateClick : LoginEvent
}