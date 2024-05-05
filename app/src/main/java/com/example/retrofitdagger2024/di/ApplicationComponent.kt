package com.example.retrofitdagger2024.di

import android.content.Context
import com.example.retrofitdagger2024.fragments.MyFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class])
interface ApplicationComponent {

    fun inject(myFragment: MyFragment)

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context) : ApplicationComponent

    }
}