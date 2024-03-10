package com.vlaskorobogatov.koutline.arch

import com.arkivanov.decompose.ComponentContext
import org.orbitmvi.orbit.ContainerHost

interface StateComponent<
    STATE : BaseState,
    SIDE_EFFECT : BaseSideEffect
    > : ComponentContext, ContainerHost<STATE, SIDE_EFFECT>
