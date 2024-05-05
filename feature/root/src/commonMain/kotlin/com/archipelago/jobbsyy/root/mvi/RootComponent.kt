package com.archipelago.jobbsyy.root.mvi

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface RootComponent {

    val childStack: Value<ChildStack<*, Child>>

    sealed class Child {
        class LoginChild(val component: LoginComponent) : Child()
        class HomeChild(val component: HomeComponent) : Child()
    }
}
