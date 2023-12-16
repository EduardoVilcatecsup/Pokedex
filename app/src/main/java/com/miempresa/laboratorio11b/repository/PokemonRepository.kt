package com.miempresa.laboratorio11b.repository

import com.miempresa.laboratorio11b.model.PokemonResponse
import com.miempresa.laboratorio11b.service.RetrofitInstance

class PokemonRepository {
    private val pokemonService = RetrofitInstance.pokemonService

        suspend fun getPokemon(pokemonNumber: Int): PokemonResponse {
            return pokemonService.getPokemon(pokemonNumber)
        }
}
