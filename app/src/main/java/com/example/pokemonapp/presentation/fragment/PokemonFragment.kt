package com.example.pokemonapp.presentation.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pokemonapp.R
import com.example.pokemonapp.databinding.FragmentPokemonBinding
import com.example.pokemonapp.presentation.viewmodel.PokemonViewModel
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel


class PokemonFragment : Fragment() {

    private var _binding: FragmentPokemonBinding? = null
    private val binding: FragmentPokemonBinding get() = _binding!!
    private val pokemonViewModel: PokemonViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentPokemonBinding.inflate(
        inflater, container, false
    ).also { _binding = it}.root

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pokemon = arguments?.getString("pokemon")

        pokemonViewModel.browsePokemon(pokemon!!)
        pokemonViewModel.pokemonData.observe(viewLifecycleOwner) {
            with(binding) {
                tvName.text = it.name
                tvWeight.text = "Weight: ${it.weight / 10} kg"
                tvHeight.text = "Height: ${it.height * 10} cm"
                Picasso.get().load(it.sprites).into(ivPokemonImage)
            }
        }


    }
}