package edu.ucne.proyecto_final.utils

sealed class Screen (val route : String){

    object RegistrodeVisitantesScreen : Screen("RegistrodeVisitantes")
    object RegistrodeInternosScreen : Screen("RegistroInternos")
    object ConsultadeVisitantesScreen : Screen("ConsultaVisitantes")
    object ConsultadeInternosScreen : Screen("ConsultaOcupacion")
}