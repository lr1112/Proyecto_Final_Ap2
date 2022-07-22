package edu.ucne.proyecto_final.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.ucne.proyecto_final.data.Visitante
import kotlinx.coroutines.flow.Flow


@Dao
interface VisitanteDao {
    @Query("SELECT * FROM visitante")
    fun selectAll(): Flow<List<Visitante>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(visitante: Visitante)
    @Query("DELETE FROM visitante WHERE VisitanteId = VisitanteId")
    suspend fun delete(visitanteId: Int)
    @Query("DELETE FROM Visitante ")
    suspend fun deleteAllInterno()

}

