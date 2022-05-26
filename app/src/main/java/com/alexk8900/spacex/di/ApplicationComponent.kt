package com.alexk8900.spacex.di

import com.alexk8900.spacex.App
import com.alexk8900.spacex.di.modules.*
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBuilder::class,
    FragmentBuilder::class,
    ViewModelModule::class,
    UseCasesBindModule::class,
    RepositoryBindModule::class,
    ApiModule::class,
])
interface ApplicationComponent : AndroidInjector<App> {
    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<App>
}
