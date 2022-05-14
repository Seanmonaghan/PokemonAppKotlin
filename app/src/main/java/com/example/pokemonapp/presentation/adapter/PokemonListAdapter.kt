package com.example.pokemonapp.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.data.local.entity.PokemonList
import com.example.pokemonapp.databinding.ItemPokemonListBinding
import com.example.pokemonapp.presentation.fragment.PokemonListFragmentDirections

class PokemonListAdapter : RecyclerView.Adapter<PokemonListAdapter.PokemonListAdapterViewHolder>() {

    private var pokemon = listOf<PokemonList>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PokemonListAdapterViewHolder {
        return PokemonListAdapterViewHolder.getInstance(parent)
    }

    override fun onBindViewHolder(holder: PokemonListAdapterViewHolder, position: Int) {
        holder.bindData(pokemon[position])
    }

    override fun getItemCount(): Int {
        return pokemon.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addItem(pokemon: List<PokemonList>) {
        this.pokemon = pokemon
        notifyDataSetChanged()
    }

    class PokemonListAdapterViewHolder(private val binding: ItemPokemonListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(pokemon: PokemonList) {
            binding.tvName.text = pokemon.name.replace("-", " ")
            binding.root.setOnClickListener {
                it.findNavController().navigate(PokemonListFragmentDirections.toDetails(pokemon.name.replaceFirstChar { char -> char.lowercase() }))
            }
        }

        companion object {
            fun getInstance(parent: ViewGroup) = ItemPokemonListBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ).let { PokemonListAdapterViewHolder(it) }
        }
    }

}