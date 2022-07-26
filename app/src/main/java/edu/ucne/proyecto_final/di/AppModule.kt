package edu.ucne.proyecto_final.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.ucne.proyecto_final.data.repository.InternoRepository
import edu.ucne.proyecto_final.data.repository.VisitanteRepository
import edu.ucne.proyecto_final.data.room.DataBase
import edu.ucne.proyecto_final.data.room.InternoDao
import edu.ucne.proyecto_final.data.room.VisitanteDao
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesInternosDb(@ApplicationContext context: Context): DataBase{
        return Room.databaseBuilder(
            context,
            DataBase::class.java,
            "InternosDb")
            .fallbackToDestructiveMigration()
            .build()
    }
    @Provides
    fun providesInternosDao(dataBase: DataBase): InternoDao{
        return dataBase.internoDao()
    }
    @Provides
    fun providesVisitanteDao(dataBase: DataBase): VisitanteDao {
        return dataBase.visitanteDao()
    }
    @Provides
    fun providesInternoRepository(internoDao: InternoDao): InternoRepository {
        return InternoRepository(internoDao)
    }
    @Provides
    fun providesVisitanteRepository(visitanteDao: VisitanteDao): VisitanteRepository {
        return VisitanteRepository(visitanteDao)
    }
}