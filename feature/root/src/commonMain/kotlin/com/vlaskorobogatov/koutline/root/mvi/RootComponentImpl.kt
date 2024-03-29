package com.vlaskorobogatov.koutline.root.mvi

import com.arkivanov.decompose.ComponentContext
import com.vlaskorobogatov.koutline.arch.ContainerComponent
import com.vlaskorobogatov.koutline.arch.blockingReduce

class RootComponentImpl(
    componentContext: ComponentContext
) : ContainerComponent<RootState, Nothing>(
    initState = RootState(),
    componentContext = componentContext
), RootComponent {

    override fun onLoginChanged(login: String) = blockingReduce { state.copy(login = login) }
    override fun onPasswordChanged(password: String) = blockingReduce { state.copy(password = password) }
    override fun onPasswordVisibilityChanged() = blockingReduce {
        state.copy(isPasswordVisible = !state.isPasswordVisible)
    }
}
