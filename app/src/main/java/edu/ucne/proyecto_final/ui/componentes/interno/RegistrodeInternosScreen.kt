package edu.ucne.proyecto_final.ui.componentes.interno

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import edu.ucne.proyecto_final.VisitanteSpinner

@Composable
fun RegistrodeInternosScreen(
    navHostController: NavHostController,
    viewModel: InternoViewModel = hiltViewModel()
) {
    var person by rememberSaveable() {
        mutableStateOf("")
    }
    var email by rememberSaveable() {
        mutableStateOf("")
    }
    var salario by rememberSaveable() {
        mutableStateOf("")
    }


    Column(modifier = Modifier.padding(8.dp)) {
        OutlinedTextField(
            value = viewModel.nombre,
            onValueChange = { viewModel.nombre = it },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Nombre de la Persona")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                )
            }
        )

        OutlinedTextField(
            value = viewModel.apellido,
            onValueChange = { viewModel.apellido = it },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Apellido del Interno")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                )
            }
        )
        OutlinedTextField(
            value = viewModel.pabellon,
            onValueChange = { viewModel.pabellon = it },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Pabellon del Interno")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            }
        )

        VisitanteSpinner()

        OutlinedTextField(
            value = viewModel.ficha,
            onValueChange = { viewModel.ficha = it },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Ficha de interno")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Face,
                    contentDescription = null
                )
            }
        )

        OutlinedButton(onClick = {
            viewModel.Guardar()
            navHostController.navigateUp()
        }) {
            Text(text = "Guardar")
        }
    }
}