package edu.ucne.proyecto_final.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.ucne.proyecto_final.data.room.DataBase
import edu.ucne.proyecto_final.data.room.InternoDao
import edu.ucne.proyecto_final.data.room.VisitanteDao


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    fun providesInternosDb(@ApplicationContext context: Context): DataBase{
        return Room.databaseBuilder(
            context,
            DataBase::class.java,
            "InternosDb")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun providesInternosDao(dataBase: DataBase): InternoDao{
        return dataBase.internoDao()
    }

    fun providesVisitanteDao(dataBase: DataBase): VisitanteDao {
        return dataBase.visitanteDao()
    }
}