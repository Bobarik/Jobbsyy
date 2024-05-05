package com.archipelago.jobbsyy.root.mvi

import com.archipelago.jobbsyy.root.mvi.RootComponent.Child.HomeChild
import com.archipelago.jobbsyy.root.mvi.RootComponent.Child.LoginChild
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable

class RootComponentImpl(
    componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext {
    private val navigation = StackNavigation<Config>()

    override val childStack: Value<ChildStack<*, RootComponent.Child>> =
        childStack(
            source = navigation,
            serializer = Config.serializer(),
            initialConfiguration = Config.Login,
            handleBackButton = true,
            childFactory = ::createChild,
        )

    private fun createChild(
        config: Config,
        componentContext: ComponentContext
    ): RootComponent.Child =
        when (config) {
            is Config.Login -> LoginChild(itemLogin(componentContext))
            is Config.Home -> HomeChild(itemHome(componentContext))
        }

    private fun itemLogin(componentContext: ComponentContext): LoginComponent =
        LoginComponentImpl(
            componentContext = componentContext,
            onHomeNavigate = {
                navigation.push(Config.Home)
            }
        )

    private fun itemHome(componentContext: ComponentContext): HomeComponent =
        HomeComponentImpl(
            componentContext = componentContext,
            onBackClicked = {
                navigation.pop()
            }
        )

    @Serializable
    private sealed class Config {
        @Serializable
        data object Login : Config()

        @Serializable
        data object Home : Config()
    }

}
