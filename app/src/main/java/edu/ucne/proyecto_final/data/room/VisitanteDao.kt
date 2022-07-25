package edu.ucne.proyecto_final.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.ucne.proyecto_final.data.Interno
import edu.ucne.proyecto_final.data.Visitante
import kotlinx.coroutines.flow.Flow


@Dao
interface VisitanteDao {
    @Query("SELECT * FROM Visitantes")
    fun selectAll(): Flow<List<Visitante>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(visitante: Visitante)
    @Query("DELETE FROM Visitantes WHERE VisitanteId = VisitanteId")
    suspend fun delete(visitanteId: Int)
    @Query("DELETE FROM Visitantes ")
    suspend fun deleteAllVisitante()
    @Query("UPDATE Visitantes SET isComplete = :isComplete WHERE visitanteId = VisitanteId")
    suspend fun updateInterno(isComplete: Boolean, visitanteId: Int)
    @Query("""
        SELECT * 
        FROM Visitantes
        ORDER BY VisitanteId   
    """)
    fun getList(): Flow<List<Visitante>>

}

