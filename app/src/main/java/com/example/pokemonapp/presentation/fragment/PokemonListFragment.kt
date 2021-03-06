package com.example.pokemonapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.pokemonapp.databinding.FragmentPokemonListBinding
import com.example.pokemonapp.presentation.adapter.PokemonListAdapter
import com.example.pokemonapp.presentation.viewmodel.PokemonViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonListFragment : Fragment() {

    private var _binding: FragmentPokemonListBinding? = null
    private val binding: FragmentPokemonListBinding get() = _binding!!
    private val pokemonViewModel: PokemonViewModel by viewModel()
    private val pokemonListAdapter by lazy { PokemonListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentPokemonListBinding.inflate(
        inflater, container, false
    ).also { _binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        Set up Recycler View
        with(binding.rvPokemonList) {
            layoutManager = StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL)
            adapter = pokemonListAdapter.apply {
                pokemonViewModel.browsePokemonList()
                pokemonViewModel.pokemonListData.observe(viewLifecycleOwner) {
                    addItem(it)
                }
            }
        }

//        Search Query On Text Change Listener
        binding.svSearchPokemon.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                pokemonViewModel.filterPokemon(query!!)
                binding.rvPokemonList.adapter = pokemonListAdapter.apply {
                    pokemonViewModel.filterInVM(binding.svSearchPokemon.query.toString())
                    pokemonViewModel.pokemonListData.observe(viewLifecycleOwner) {
                        addItem(it)
                    }
                    return false
                }
            }
        })
    }
}



