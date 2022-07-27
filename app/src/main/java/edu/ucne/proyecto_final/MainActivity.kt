package edu.ucne.proyecto_final

import android.graphics.Paint
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.proyecto_final.data.Interno
import edu.ucne.proyecto_final.data.Visitante
import edu.ucne.proyecto_final.ui.componentes.interno.ConsultadeInternosScreen
import edu.ucne.proyecto_final.ui.componentes.interno.InternoViewModel
import edu.ucne.proyecto_final.ui.componentes.interno.RegistrodeInternosScreen
import edu.ucne.proyecto_final.ui.componentes.visitante.ConsultadeVisitantesScreen
import edu.ucne.proyecto_final.ui.componentes.visitante.RegistrodeVisitantesScreen
import edu.ucne.proyecto_final.ui.componentes.visitante.VisitanteViewModel
import edu.ucne.proyecto_final.ui.theme.Proyecto_FinalTheme
import edu.ucne.proyecto_final.utils.Screen

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
                    MyApp()
                }
            }
        }
    }
}
@Composable
fun MyApp() {
    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = Screen.ConsultadeInternosScreen.route){
        composable(Screen.ConsultadeVisitantesScreen.route){
            ConsultadeVisitantesScreen(navHostController = navHostController)
        }
        composable(Screen.RegistrodeVisitantesScreen.route){
            RegistrodeVisitantesScreen(navHostController = navHostController)
        }
        composable(Screen.ConsultadeInternosScreen.route){
            ConsultadeInternosScreen(navHostController = navHostController)
        }
        composable(Screen.RegistrodeInternosScreen.route){
            RegistrodeInternosScreen(navHostController = navHostController)
        }
    }
}

@Composable
fun RowVisitante(visitante: Visitante){
    Row() {
        Text(text = visitante.Nombre)
        Text(text = visitante.Apellido)
        Text(text = visitante.Parentesco)

    }

}
@Composable
fun RowInterno(interno: Interno) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(text = "Nombre: ${interno.Nombre}")
        Text(text = interno.Apellido)
        Text(text = "   FICHA: ${interno.Ficha}")

    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(text = "PABELLON: ${interno.Pabellon}")

    }
}
@Composable
fun VisitanteSpinner(
    viewModel: VisitanteViewModel = hiltViewModel(),
    viewModelP: InternoViewModel = hiltViewModel()
){
    val visitantes = viewModel.visitantes.collectAsState(initial = emptyList())

    var internoText by remember{
        mutableStateOf(" ")
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
                        viewModelP.internoId = interno.VisitanteId
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
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Proyecto_FinalTheme {
        MyApp()
    }
}