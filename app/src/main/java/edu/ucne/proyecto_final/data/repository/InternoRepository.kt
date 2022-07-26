package edu.ucne.proyecto_final.data.repository

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.ucne.proyecto_final.data.Interno
import edu.ucne.proyecto_final.data.room.InternoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class InternoRepository @Inject constructor(private val internoDao: InternoDao) {

            suspend fun insertTodo(interno: Interno) {
        Dispatchers.IO.apply {
            internoDao.insert(interno)
        }
    }

            suspend fun deleteTodo(interno: Interno) {
        Dispatchers.IO.apply {
            internoDao.delete(interno)
        }
    }
        suspend fun updateInterno(isComplete: Boolean) {
        Dispatchers.IO.apply {
            internoDao.updateInterno(isComplete)
        }
    }
    fun getList(): Flow<List<Interno>> {
        return internoDao.getList()

    }
}