package com.example.pokemonapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokemonapp.data.local.entity.Pokemon
import com.example.pokemonapp.data.local.entity.PokemonList

@Dao
abstract class PokemonListDao {

    @Query("SELECT * FROM PokemonList")
    abstract fun getAllPokemon(): List<PokemonList>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertPokemon(pokemonList: List<PokemonList>)

    @Query("SELECT * FROM PokemonList WHERE name LIKE :filter || '%'")
    abstract fun filterPokemon(filter: String): List<PokemonList>
}