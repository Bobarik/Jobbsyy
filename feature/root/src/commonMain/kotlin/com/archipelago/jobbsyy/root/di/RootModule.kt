package com.archipelago.jobbsyy.root.di

import com.archipelago.jobbsyy.root.mvi.RootComponent
import com.archipelago.jobbsyy.root.mvi.RootComponentImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val RootModule = module {
    factoryOf(::RootComponentImpl) bind RootComponent::class
}
