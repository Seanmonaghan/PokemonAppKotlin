package com.example.pokemonapp.data.repo

import com.example.pokemonapp.data.remote.service.PokemonService
import com.example.pokemonapp.di.providesRetrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonRepo(
    private val service: PokemonService = providesRetrofit()
) {

    suspend fun getAllPokemon() = withContext(Dispatchers.IO) {
        return@withContext service.getAllPokemon()
    }
}