package com.example.pokemonapp.data.repo

import com.example.pokemonapp.data.local.database.PokemonDatabase
import com.example.pokemonapp.data.local.entity.PokemonList
import com.example.pokemonapp.data.remote.service.PokemonService
import com.example.pokemonapp.di.providesRetrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

class PokemonRepo(
    private val service: PokemonService = providesRetrofit(),
    private val database: PokemonDatabase
) {
    suspend fun getPokemonList(): List<PokemonList> = withContext(Dispatchers.IO) {
        return@withContext database.pokemonListDao().getAllPokemon().ifEmpty {
            val pokemonList: List<PokemonList> = service.getAllPokemon().results.map {
                PokemonList(
                    name = it.name,
                )
            }
            database.pokemonListDao().insertPokemon(pokemonList)
            return@ifEmpty pokemonList
        }
    }
}


