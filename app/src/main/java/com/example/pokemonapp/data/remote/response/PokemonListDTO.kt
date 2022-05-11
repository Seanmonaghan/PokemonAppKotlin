package com.example.pokemonapp.data.remote.response


data class PokemonListDTO(
    val count: Int,
    val next: Any?,
    val previous: Any?,
    val results: List<Result>
)

data class Result(
    val name: String,
    val url: String
)