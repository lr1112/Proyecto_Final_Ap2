package edu.ucne.proyecto_final.data.room

import androidx.room.*
import edu.ucne.proyecto_final.data.Interno
import kotlinx.coroutines.flow.Flow


@Dao
interface InternoDao {
    @Query("SELECT * FROM Internos")
    fun selectAll(): Flow<List<Interno>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(interno: Interno)
    @Delete
    suspend fun delete(interno: Interno)
    @Query("DELETE FROM Internos ")
    suspend fun deleteAllInterno()
    @Query("UPDATE Internos SET isComplete = :isComplete ")
    suspend fun updateInterno(isComplete: Boolean)
    @Query("""
        SELECT * 
        FROM Internos
        ORDER BY InternoId   
    """)
    fun getList(): Flow<List<Interno>>

}