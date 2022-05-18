package com.ejemplo.registro_personas.views.personas

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ejemplo.registro_personas.R
import com.ejemplo.registro_personas.databinding.ListaPersonasFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListaPersonasFragment : Fragment() {

   // private lateinit var viewModel: ListaPersonasViewModel
    private lateinit var binding: ListaPersonasFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = ListaPersonasFragmentBinding.inflate(inflater, container, false)

        binding.personaButton.setOnClickListener {
            findNavController().navigate(R.id.action_to_personasFragment)
        }

        return binding.root
    }



}