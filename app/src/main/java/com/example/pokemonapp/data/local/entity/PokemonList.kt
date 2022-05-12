package com.example.pokemonapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonList(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String
)
