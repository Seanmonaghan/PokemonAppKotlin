package com.example.pokemonapp.di

import android.content.Context
import androidx.room.Room
import com.example.pokemonapp.data.local.database.PokemonDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localModule = module {
    single { provideDatabase(this.androidContext()) }
}


private const val DB_NAME = "pokemon.db"

@Volatile
private var instance: PokemonDatabase? = null

private fun databaseBuilder(context: Context): PokemonDatabase = Room.databaseBuilder(
    context, PokemonDatabase::class.java, DB_NAME
).build()

fun provideDatabase(context: Context): PokemonDatabase {
    return instance ?: databaseBuilder(context).also {
        instance = it
    }
}






