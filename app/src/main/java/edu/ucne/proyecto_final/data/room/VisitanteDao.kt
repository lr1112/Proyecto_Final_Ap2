package edu.ucne.proyecto_final.data.room

import androidx.room.*
import edu.ucne.proyecto_final.data.Interno
import edu.ucne.proyecto_final.data.Visitante
import kotlinx.coroutines.flow.Flow


@Dao
interface VisitanteDao {
    @Query("SELECT * FROM Visitantes")
    fun selectAll(): Flow<List<Visitante>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(visitante: Visitante)
    @Delete
    suspend fun delete(visitante: Visitante)

    @Query("DELETE FROM Visitantes ")
    suspend fun deleteAllVisitante()

    @Query("UPDATE Visitantes SET isComplete = :isComplete ")
    suspend fun updateVisitante(isComplete: Boolean)


    @Query("""
        SELECT * 
        FROM Visitantes
        ORDER BY VisitanteId   
    """)
    fun getList(): Flow<List<Visitante>>

}

