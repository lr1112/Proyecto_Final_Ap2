package edu.ucne.proyecto_final.ui.componentes.visitante

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun RegistrodeVisitantesScreen(
    navHostController: NavHostController,
    viewModel: VisitanteViewModel = hiltViewModel()
){

    Column(modifier = Modifier.padding(8.dp)) {
        OutlinedTextField(
            value = viewModel.nombre,
            onValueChange = {viewModel.nombre = it},
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Nombre del Visitante")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = null)
            }
        )
        OutlinedTextField(
            value = viewModel.apellido,
            onValueChange = { viewModel.apellido = it },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Apellido del Visitante")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null
                )
            }
        )
        OutlinedTextField(
            value = viewModel.parentesco,
            onValueChange = { viewModel.parentesco = it },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Parentesco del Visitante")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
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