package edu.ucne.proyecto_final.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.ucne.proyecto_final.data.Interno
import kotlinx.coroutines.flow.Flow


@Dao
interface InternoDao {
    @Query("SELECT * FROM interno")
    fun selectAll(): Flow<List<Interno>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(interno: Interno)
    @Query("DELETE FROM interno WHERE internoId = InternoId")
    suspend fun delete(internoId: Int)
    @Query("DELETE FROM Interno ")
    suspend fun deleteAllInterno()
    @Query("UPDATE interno SET isComplete = :isComplete WHERE internoId = InternoId")
    suspend fun updateInterno(isComplete: Boolean, internoId: Int)

}