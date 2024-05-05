package com.archipelago.jobbsyy.root.di

import com.archipelago.jobbsyy.root.mvi.LoginComponentImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val LoginModule = module {
    factoryOf(::LoginComponentImpl)
}
