package com.ejemplo.registro_personas.di

import android.content.Context
import androidx.room.Room
import com.ejemplo.registro_personas.data.PersonaDao
import com.ejemplo.registro_personas.data.PersonasDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun ProvidePersonasDB(@ApplicationContext appContext: Context): PersonasDb
    {
        return Room.databaseBuilder(
            appContext,
            PersonasDb::class.java,
            "Personas.db")
            .fallbackToDestructiveMigration()
            .build()

    }

    @Provides
    fun ProvidePersonaDao(personasDb:PersonasDb): PersonaDao {
        return personasDb.personaDao
    }
}