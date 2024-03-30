package com.archipelago.jobssyy.root.di

import com.archipelago.jobbsyy.root.mvi.RootComponentImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val RootModule = module {
    factoryOf(::RootComponentImpl)
}
