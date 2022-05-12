package com.example.pokemonapp.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PokemonApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PokemonApplication)
            androidLogger()
            modules(
                listOf(
                    remoteModule,
                    localModule,
                    viewModelModule
                )
            )
        }
    }
}