package com.ejemplo.registro_personas.views.personas

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.ejemplo.registro_personas.R
import com.ejemplo.registro_personas.databinding.ListaPersonasFragmentBinding
import com.ejemplo.registro_personas.model.Persona
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListaPersonasFragment : Fragment() {

    private val viewModel: PersonasViewModel by viewModels()
    private lateinit var binding: ListaPersonasFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = ListaPersonasFragmentBinding.inflate(inflater, container, false)


        val adapter = PersonaAdapter(){
            OnPersonaClicked(it)
        }
        binding.profesionesRecyclerView.adapter = adapter

        lifecycleScope.launch{
            viewModel.personas.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect {  Lista ->
                    adapter.submitList(Lista)
                }
        }



        binding.personaButton.setOnClickListener {
            findNavController().navigate(R.id.action_to_personasFragment)
        }

        return binding.root
    }

    private fun OnPersonaClicked(persona: Persona) {
        val action = ListaPersonasFragmentDirections.actionToPersonasFragment(persona)
        findNavController().navigate(action)
    }


}