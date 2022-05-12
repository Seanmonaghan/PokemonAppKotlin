package com.example.pokemonapp.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.pokemonapp.data.local.entity.Pokemon

@Dao
abstract class PokemonDao {
    @Query("SELECT * FROM Pokemon")
    abstract fun getPokemon(): Pokemon
}