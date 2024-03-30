package com.archipelago.jobbsyy.di

import com.archipelago.jobbsyy.root.mvi.RootComponentImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val AppModule = module {
    factoryOf(::RootComponentImpl)
}
