package edu.ucne.proyecto_final.ui.componentes.visitante

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.proyecto_final.data.Visitante
import edu.ucne.proyecto_final.data.repository.VisitanteRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VisitanteViewModel @Inject constructor(
    val visitanteRepository : VisitanteRepository
) : ViewModel(){
    var nombre by mutableStateOf("")
    var apellido by mutableStateOf("")
    var parentesco by mutableStateOf("")
    var visitanteId by mutableStateOf(0)

    var visitantes = visitanteRepository.getList()
        private set

    fun Guardar(){
        viewModelScope.launch {
            visitanteRepository.insertTodo(
                Visitante(
                    Nombre = nombre,
                    Apellido = apellido,
                    Parentesco = parentesco,
                    VisitanteId = visitanteId,

                )
            )
        }
    }
}