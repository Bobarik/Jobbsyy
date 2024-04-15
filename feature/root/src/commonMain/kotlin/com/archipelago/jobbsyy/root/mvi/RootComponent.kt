package com.archipelago.jobbsyy.root.mvi

import com.archipelago.jobbsyy.arch.StateComponent

interface RootComponent : StateComponent<RootState, Nothing> {

    fun onLoginChanged(login: String)
    fun onPasswordChanged(password: String)
    fun onPasswordVisibilityChanged()
}
