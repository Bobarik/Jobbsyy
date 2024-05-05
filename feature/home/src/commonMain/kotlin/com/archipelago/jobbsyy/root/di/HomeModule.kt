package com.archipelago.jobbsyy.root.di

import com.archipelago.jobbsyy.root.mvi.HomeComponent
import com.archipelago.jobbsyy.root.mvi.HomeComponentImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val HomeModule = module {
    factoryOf(::HomeComponentImpl) bind HomeComponent::class
}
