package com.example.pokemonapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pokemonapp.data.local.dao.PokemonDao
import com.example.pokemonapp.data.local.dao.PokemonListDao
import com.example.pokemonapp.data.local.entity.Pokemon
import com.example.pokemonapp.data.local.entity.PokemonList

@Database(entities = [Pokemon::class, PokemonList::class], version = 1)
abstract class PokemonDatabase: RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
    abstract fun pokemonListDao(): PokemonListDao
}