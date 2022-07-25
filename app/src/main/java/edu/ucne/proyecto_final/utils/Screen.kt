package edu.ucne.proyecto_final.utils

sealed class Screen (val route : String){

    object RegistrodeVisitantesScreen : Screen("RegistrodeVisitantes")
    object RegistroOcupacionesScreen : Screen("RegistroOcupaciones")
    object ConsultaPersonaScreen : Screen("ConsultaPersonas")
    object ConsultaOcupacionScreen : Screen("ConsultaOcupacion")
}