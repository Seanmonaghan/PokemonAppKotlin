package com.example.pokemonapp.di

import com.example.pokemonapp.data.repo.PokemonRepo
import com.example.pokemonapp.presentation.viewmodel.PokemonViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { PokemonViewModel(PokemonRepo(providesRetrofit(), provideDatabase(androidContext()))) }

}