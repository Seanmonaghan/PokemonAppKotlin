package com.example.pokemonapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.data.local.entity.Pokemon
import com.example.pokemonapp.data.local.entity.PokemonList
import com.example.pokemonapp.data.repo.PokemonRepo
import kotlinx.coroutines.launch


class PokemonViewModel(
    private val repo: PokemonRepo
) : ViewModel() {


    private val _pokemonListData = MutableLiveData<List<PokemonList>>()
    val pokemonListData: LiveData<List<PokemonList>> get() = _pokemonListData

    private val _pokemonData = MutableLiveData<Pokemon>()
    val pokemonData: LiveData<Pokemon> get() = _pokemonData

    fun browsePokemonList() {
        viewModelScope.launch {
            _pokemonListData.value = repo.getPokemonList()
        }
    }

    fun filterPokemon(filter: String) {
        viewModelScope.launch {
            _pokemonListData.value = repo.getFilteredList(filter)
        }
    }

    fun browsePokemon(pokemon: String) {
        viewModelScope.launch {
            _pokemonData.value = repo.getPokemon(pokemon).getOrNull()
        }
    }

    fun filterInVM(filter: String) {
        viewModelScope.launch {
            _pokemonListData.value = repo.getPokemonList().filter {
                it.name.contains(
                    filter,
                    ignoreCase = true
                )
            }
        }
    }
}