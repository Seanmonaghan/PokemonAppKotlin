package com.example.pokemonapp.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.pokemonapp.data.local.entity.PokemonList

@Dao
abstract class PokemonListDao {

    @Query("SELECT * FROM PokemonList")
    abstract fun getAllPokemon() : PokemonList
}