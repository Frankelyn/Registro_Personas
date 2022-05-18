package com.ejemplo.registro_personas.views.personas

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ejemplo.registro_personas.data.PersonaDao
import com.ejemplo.registro_personas.model.Persona
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonasViewModel @Inject constructor(
    val personaDao: PersonaDao
) : ViewModel() {

    fun guardar(persona: Persona){
        viewModelScope.launch {
            personaDao.Insertar(persona)
        }
    }
}