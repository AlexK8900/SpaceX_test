package com.alexk8900.spacex.di.modules

import com.alexk8900.spacex.data.rest.Api
import com.alexk8900.spacex.data.rest.ApiFactory
import dagger.Module
import dagger.Provides

@Module
class ApiModule {

    @Provides
    fun provideApi(): Api =
        ApiFactory().createApi()
}