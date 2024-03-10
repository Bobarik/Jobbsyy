package com.vlaskorobogatov.koutline.mvi

import com.vlaskorobogatov.koutline.arch.BaseState

data class RootState(
    val login: String = "",
    val password: String = "",
    val isPasswordVisible: Boolean = false,
) : BaseState
