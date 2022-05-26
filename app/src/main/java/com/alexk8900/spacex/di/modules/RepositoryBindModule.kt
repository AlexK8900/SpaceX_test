package com.alexk8900.spacex.di.modules

import com.alexk8900.spacex.data.repositories.CardRepositoryImpl
import com.alexk8900.spacex.domain.repositories.CardRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryBindModule {

    @Binds
    fun bindCardRepositoryImpl_to_CardRepository(CardRepositoryImpl: CardRepositoryImpl): CardRepository
}