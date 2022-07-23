package edu.ucne.proyecto_final.data.repository


import edu.ucne.proyecto_final.data.Visitante
import edu.ucne.proyecto_final.data.room.VisitanteDao
import kotlinx.coroutines.Dispatchers

class VisitanteRepository (private val visitanteDao: VisitanteDao){
    suspend fun insertTodo(visitante: Visitante) {
        Dispatchers.IO.apply {
            visitanteDao.insert(visitante)
        }
    }

    suspend fun deleteTodo(visitante: Visitante) {
        Dispatchers.IO.apply {
            visitanteDao.delete(visitante.VisitanteId)
        }
    }

    suspend fun updateTodo(isComplete: Boolean, visitanteId: Int) {
        Dispatchers.IO.apply {
            visitanteDao.updateInterno(isComplete, visitanteId)
        }
    }
}