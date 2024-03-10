package com.vlaskorobogatov.koutline.di

import com.vlaskorobogatov.koutline.mvi.RootComponentImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val AppModule = module {
    factoryOf(::RootComponentImpl)
}
