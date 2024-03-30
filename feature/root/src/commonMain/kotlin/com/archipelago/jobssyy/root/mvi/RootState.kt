package com.archipelago.jobbsyy.root.mvi

import com.archipelago.jobbsyy.arch.BaseState

data class RootState(
    val login: String = "",
    val password: String = "",
    val isPasswordVisible: Boolean = false,
) : BaseState
