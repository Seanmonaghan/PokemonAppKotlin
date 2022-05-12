package com.example.pokemonapp.di

import com.example.pokemonapp.data.remote.service.PokemonService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val remoteModule = module {
    single { providesRetrofit() }
}

const val BASE_URL = "https://pokeapi.co/api/v2"

fun providesRetrofit(): PokemonService {

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit.create(PokemonService::class.java)
}