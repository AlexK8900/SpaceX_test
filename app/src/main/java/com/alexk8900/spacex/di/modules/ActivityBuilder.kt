package com.alexk8900.spacex.di.modules

import com.alexk8900.spacex.ui.home_scope.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBuilder {
    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity
}