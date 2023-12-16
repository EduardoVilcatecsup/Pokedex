package com.miempresa.laboratorio11b.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.miempresa.laboratorio11b.model.PokemonResponse
import com.miempresa.laboratorio11b.viewmodel.PokemonViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonScreen(viewModel: PokemonViewModel) {
    val pokemones by viewModel.pokemon.observeAsState(null)
    var pokemonNumber by remember { mutableStateOf("1") }


    Column {
        TextField(
            value = pokemonNumber,
            onValueChange = {
                // Validamos para que solo se permitan números
                if (it.isDigitsOnly()) {
                    pokemonNumber = it
                }
            },
            label = { Text("Número del Pokémon") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.padding(16.dp))

        Button(
            onClick = {
                viewModel.fetchPokemon(pokemonNumber.toInt())
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Obtener Información")
        }

        if (pokemones == null) {
            Text(text = "Loading...")
        } else {
            PokemonItem(pokemones!!)
        }
    }
}


@Composable
fun PokemonItem(pokemon: PokemonResponse) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Información del Pokémon:",
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
            )
            Text(
                text = "Nombre: ${pokemon.forms.getOrNull(0)!!.name}\n"+
                        "Habilidades:"
            )
            // Itera sobre las habilidades y muestra sus nombres
            for (ability in pokemon.abilities) {
                Text(
                    text = "- ${ability.ability.name}",
                    style = TextStyle(fontSize = 14.sp)
                )
            }

        }
    }
}