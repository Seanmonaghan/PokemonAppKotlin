package com.example.pokemonapp.presentation.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemonapp.R
import com.example.pokemonapp.di.localModule
import com.example.pokemonapp.di.remoteModule
import org.koin.core.context.startKoin

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)

        startKoin {
            modules(listOf(
                remoteModule,
                localModule,
            ))
        }
    }
}