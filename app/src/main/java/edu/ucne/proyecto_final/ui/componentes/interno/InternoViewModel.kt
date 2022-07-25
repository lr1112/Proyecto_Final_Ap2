package edu.ucne.proyecto_final.ui.componentes.interno

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.proyecto_final.data.Interno
import edu.ucne.proyecto_final.data.repository.InternoRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InternoViewModel @Inject constructor(
    val internoRepository: InternoRepository
) : ViewModel() {
    var nombre by mutableStateOf("")

    var apellido by mutableStateOf("")

    var internoId by mutableStateOf(0)

    var ficha by mutableStateOf("")
    var pabellon by mutableStateOf("")

    var interno = internoRepository.getList()
        private set

    fun Guardar(){
        viewModelScope.launch{
            internoRepository.insertTodo(
                Interno(
                    Nombre = nombre,
                    Apellido = apellido,
                    InternoId = internoId,
                    Ficha = ficha,
                    Pabellon = pabellon
                )
            )
        }
    }
}