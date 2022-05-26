package com.alexk8900.spacex.di.modules

import com.alexk8900.spacex.application.interactors.CardInteractor
import com.alexk8900.spacex.domain.usecases.CardUseCase
import dagger.Binds
import dagger.Module

@Module
interface UseCasesBindModule {

    @Binds
    fun bindHomeInteractor_to_HomeUseCase(homeInteractor: CardInteractor): CardUseCase
}