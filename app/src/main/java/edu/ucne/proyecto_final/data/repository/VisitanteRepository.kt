package edu.ucne.proyecto_final.data.repository


import edu.ucne.proyecto_final.data.Interno
import edu.ucne.proyecto_final.data.Visitante
import edu.ucne.proyecto_final.data.room.VisitanteDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VisitanteRepository @Inject constructor(private val visitanteDao: VisitanteDao){
    suspend fun insertTodo(visitante: Visitante) {
        Dispatchers.IO.apply {
            visitanteDao.insert(visitante)
        }
    }

    suspend fun deleteTodo(visitante: Visitante) {
        Dispatchers.IO.apply {
            visitanteDao.delete(visitante)
        }
    }

    suspend fun updateTodo(isComplete: Boolean) {
        Dispatchers.IO.apply {
            visitanteDao.updateVisitante(isComplete)
        }
    }
    fun getList(): Flow<List<Visitante>> {
        return visitanteDao.getList()

    }
    fun buscar(nombre: String): Flow<Visitante> {
        return visitanteDao.buscar(nombre)
    }
}