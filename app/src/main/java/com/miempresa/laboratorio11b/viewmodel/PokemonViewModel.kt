package com.miempresa.laboratorio11b.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miempresa.laboratorio11b.model.PokemonResponse
import com.miempresa.laboratorio11b.repository.PokemonRepository
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {
    private val repository = PokemonRepository()
    private val _pokemon = MutableLiveData<PokemonResponse>()
    val pokemon: LiveData<PokemonResponse> = _pokemon


    fun fetchPokemon(pokemonNumber: Int) {
        viewModelScope.launch {
            try {
                val poke = repository.getPokemon(pokemonNumber)
                _pokemon.value = poke
                Log.e("FetchPokemon", _pokemon.value.toString());
            } catch (e: Exception) {
                // Handle error
                Log.e("FetchPokemon", e.message.toString());
            }
        }
    }
}
