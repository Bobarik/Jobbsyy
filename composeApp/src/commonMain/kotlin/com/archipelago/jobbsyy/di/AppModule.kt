package com.archipelago.jobbsyy.di

import com.archipelago.jobbsyy.root.di.RootModule
import org.koin.dsl.module

val AppModule = module {
    includes(RootModule)
}