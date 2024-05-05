package com.archipelago.jobbsyy.root.mvi

import com.archipelago.jobbsyy.arch.BaseState

data class LoginState(
    val login: String = "",
    val password: String = "",
    val isPasswordVisible: Boolean = false,
) : BaseState
