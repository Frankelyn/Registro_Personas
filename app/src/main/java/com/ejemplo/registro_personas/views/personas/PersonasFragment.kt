package com.ejemplo.registro_personas.views.personas

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ejemplo.registro_personas.R
import com.ejemplo.registro_personas.databinding.PersonasFragmentBinding
import com.ejemplo.registro_personas.model.Persona
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonasFragment : Fragment() {


    private val viewModel: PersonasViewModel by viewModels()
    private lateinit var binding: PersonasFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = PersonasFragmentBinding.inflate(inflater, container, false)

        binding.guardarButton.setOnClickListener {

            val persona = Persona (0, binding.nombresEditText.text.toString(),
            binding.emailEditText.text.toString(),
            binding.ocupacionEditText.text.toString(),
            binding.salarioEditText.floatValue()
            )
            viewModel.guardar(persona)

            val snackbar = Snackbar.make(binding.root, "Persona Guardada", Snackbar.LENGTH_LONG)
            snackbar.show()
        }

        return binding.root
    }

    fun TextInputEditText.floatValue() = text.toString().toFloatOrNull() ?: 0.0f

}