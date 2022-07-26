package edu.ucne.proyecto_final.ui.componentes.interno


import android.util.Log.d
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import edu.ucne.proyecto_final.RowInterno
import edu.ucne.proyecto_final.RowVisitante
import edu.ucne.proyecto_final.data.Visitante
import edu.ucne.proyecto_final.selectedVisitante
import edu.ucne.proyecto_final.ui.componentes.visitante.VisitanteViewModel
import edu.ucne.proyecto_final.utils.Screen
import androidx.compose.ui.res.painterResource

@Composable
fun ConsultadeInternosScreen(
    navHostController: NavHostController,
    viewModel: InternoViewModel = hiltViewModel(),
    viewModelV: VisitanteViewModel = hiltViewModel()
){

    Scaffold(
        modifier = Modifier.background(Color.Gray),
        topBar = {


            Image(painter = painterResource(id = edu.ucne.proyecto_final.R.drawable.rafey), contentDescription = null)
            TopAppBar(

                title = { Text(text = "Consulta de Internos del centro Rafey Hombres")},



                )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navHostController.navigate(Screen.RegistrodeInternosScreen.route)
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }

    ) {
        Column(modifier = Modifier
            .padding(it)
            .padding(8.dp)) {

            Button(onClick = { navHostController.navigate(Screen.ConsultadeVisitantesScreen.route) }) {
                Text(text = "Nuevo Visitante")

            }
            val lista = viewModel.interno.collectAsState(initial = emptyList())
           //val lista2 = viewModelV.visitantes.collectAsState(initial = emptyList())

            LazyColumn(modifier = Modifier.fillMaxWidth()){
                items(lista.value){
                        interno -> RowInterno(interno = interno)



                }

              /* items(lista2.value){
                        visitante -> RowVisitante(visitante = visitante)

                }*/

            }
        }
    }
}




