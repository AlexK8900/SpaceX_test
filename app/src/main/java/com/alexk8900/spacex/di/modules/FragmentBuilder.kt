package com.alexk8900.spacex.di.modules

import com.alexk8900.spacex.ui.home_scope.DescriptionFragment
import com.alexk8900.spacex.ui.home_scope.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentBuilder {
    @ContributesAndroidInjector
    fun provideHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    fun provideDescriptionFragment(): DescriptionFragment
}