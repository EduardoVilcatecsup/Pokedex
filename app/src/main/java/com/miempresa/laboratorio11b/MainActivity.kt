package com.miempresa.laboratorio11b

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.miempresa.laboratorio11b.ui.theme.Laboratorio11bTheme
import com.miempresa.laboratorio11b.view.PokemonScreen
import com.miempresa.laboratorio11b.viewmodel.PokemonViewModel

class MainActivity : ComponentActivity() {
    private val viewModel : PokemonViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio11bTheme {
                // Utiliza un Surface u otro contenedor principal si es necesario
                Surface(modifier = Modifier.fillMaxSize()) {
                    PokemonScreen(viewModel)
                }
            }
        }
    }
}



