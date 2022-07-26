package edu.ucne.proyecto_final

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.proyecto_final.data.Interno
import edu.ucne.proyecto_final.data.Visitante
import edu.ucne.proyecto_final.ui.componentes.interno.InternoViewModel
import edu.ucne.proyecto_final.ui.componentes.visitante.VisitanteViewModel
import edu.ucne.proyecto_final.ui.theme.Proyecto_FinalTheme

var selectedVisitante: String? = null
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proyecto_FinalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@Composable
fun RowVisitante(visitante: Visitante){
    Row() {
        Text(text = visitante.Nombre)
    }
}
@Composable
fun VisitanteSpinner(
    viewModel: VisitanteViewModel = hiltViewModel(),
    viewModelP: InternoViewModel = hiltViewModel()
){
    val visitantes = viewModel.visitantes.collectAsState(initial = emptyList())

    var internoText by remember{
        mutableStateOf("")
    }
    var expended by remember{
        mutableStateOf(false)
    }
    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Row(Modifier
            .fillMaxWidth()
            .clickable {
                expended = !expended
            }
            .padding(8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){

            Text(text = internoText, fontSize = 18.sp, modifier = Modifier.padding(end = 8.dp))
            Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "")
            DropdownMenu(expanded = expended, onDismissRequest = { expended = false}) {
                visitantes.value.forEach {
                        interno ->
                    DropdownMenuItem(onClick = {
                        viewModelP.internoId =interno.VisitanteId
                        expended = false
                        internoText = interno.Parentesco
                        selectedVisitante = interno.Nombre
                    }) {
                        Text(text = interno.Nombre)
                    }
                }

            }
        }
    }
}