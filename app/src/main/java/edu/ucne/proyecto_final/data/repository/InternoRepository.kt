package edu.ucne.proyecto_final.data.repository

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.ucne.proyecto_final.data.Interno
import edu.ucne.proyecto_final.data.room.InternoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class InternoRepository(private val internoDao: InternoDao) {

            suspend fun insertTodo(interno: Interno) {
        Dispatchers.IO.apply {
            internoDao.insert(interno)
        }
    }

            suspend fun deleteTodo(interno: Interno) {
        Dispatchers.IO.apply {
            internoDao.delete(interno.InternoId)
        }
    }
        suspend fun updateInterno(isComplete: Boolean, internoId: Int) {
        Dispatchers.IO.apply {
            internoDao.updateInterno(isComplete, internoId)
        }
    }
    fun getList(): Flow<List<Interno>> {
        return internoDao.getList()
    }
}