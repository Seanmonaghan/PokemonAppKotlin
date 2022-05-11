package com.example.pokemonapp.data.remote.service

import com.example.pokemonapp.data.remote.response.PokemonDTO
import com.example.pokemonapp.data.remote.response.PokemonListDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    @GET("/pokemon?limit=10000&offset=0")
    suspend fun getAllPokemon(): PokemonListDTO

    @GET("/pokemon/{name}")
    suspend fun getPokemon(@Path("name") name: String): PokemonDTO


}