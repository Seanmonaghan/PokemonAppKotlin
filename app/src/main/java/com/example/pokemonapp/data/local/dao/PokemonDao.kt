package com.example.pokemonapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokemonapp.data.local.entity.Pokemon

@Dao
abstract class PokemonDao {
    @Query("SELECT * FROM Pokemon WHERE name IS :pokemon")
    abstract fun getPokemon(pokemon: String): Pokemon

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insertPokemon(pokemon: Pokemon)
}