package edu.ucne.proyecto_final.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.ucne.proyecto_final.data.Interno
import kotlinx.coroutines.flow.Flow


@Dao
interface InternoDao {
    @Query("SELECT * FROM Internos")
    fun selectAll(): Flow<List<Interno>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(interno: Interno)
    @Query("DELETE FROM Internos WHERE internoId = InternoId")
    suspend fun delete(internoId: Int)
    @Query("DELETE FROM Internos ")
    suspend fun deleteAllInterno()
    @Query("UPDATE Internos SET isComplete = :isComplete WHERE internoId = InternoId")
    suspend fun updateInterno(isComplete: Boolean, internoId: Int)
    @Query("""
        SELECT * 
        FROM Internos
        ORDER BY InternoId   
    """)
    fun getList(): Flow<List<Interno>>

}