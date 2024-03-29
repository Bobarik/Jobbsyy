package com.vlaskorobogatov.koutline.root.mvi

import com.vlaskorobogatov.koutline.arch.StateComponent

interface RootComponent : StateComponent<RootState, Nothing> {

    fun onLoginChanged(login: String)
    fun onPasswordChanged(password: String)
    fun onPasswordVisibilityChanged()
}
