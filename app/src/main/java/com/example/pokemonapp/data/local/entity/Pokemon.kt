package com.example.pokemonapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pokemonapp.data.remote.response.Sprites

@Entity
data class Pokemon(
    @PrimaryKey
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Long,
    val sprites: String
)