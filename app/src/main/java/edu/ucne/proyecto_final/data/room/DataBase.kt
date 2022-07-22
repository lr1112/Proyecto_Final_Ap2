package edu.ucne.proyecto_final.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.ucne.proyecto_final.data.Interno
import edu.ucne.proyecto_final.data.Visitante



@Database(entities = [Interno::class, Visitante::class], version = 1, exportSchema = false
)
abstract class DataBase : RoomDatabase() {
    abstract fun internoDao(): InternoDao
    abstract fun visitanteDao(): VisitanteDao

    companion object {
        @Volatile
        private var INSTANCE: DataBase? = null
        fun getDatabase(context: Context): DataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataBase::class.java,
                    "todo_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}