package edu.ucne.proyecto_final.ui.componentes.visitante

import android.widget.SearchView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import edu.ucne.proyecto_final.RowVisitante
import edu.ucne.proyecto_final.utils.Screen


@Composable
fun ConsultadeVisitantesScreen(
    navHostController: NavHostController,
    viewModel : VisitanteViewModel = hiltViewModel()
){


         Scaffold(
                 topBar = {
                    TopAppBar(
                         title = { Text(text = "Consulta de Visitantes") }
                    )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navHostController.navigate(Screen.RegistrodeVisitantesScreen.route)
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }

    ) {


        Column(modifier = Modifier
            .padding(it)
            .padding(8.dp)) {

            val lista = viewModel.visitantes.collectAsState(initial = emptyList())

            LazyColumn(modifier = Modifier.fillMaxWidth()){
                items(lista.value){

                        visitante -> RowVisitante(visitante = visitante)
                      //  Divider(modifier = Modifier.fillMaxWidth().size(2.dp), color = Color.Black)
                }

            }


        }
    }

}


