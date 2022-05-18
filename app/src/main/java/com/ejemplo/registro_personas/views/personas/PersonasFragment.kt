package com.ejemplo.registro_personas.views.personas

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ejemplo.registro_personas.R

class PersonasFragment : Fragment() {

    companion object {
        fun newInstance() = PersonasFragment()
    }

    private lateinit var viewModel: PersonasViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.personas_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PersonasViewModel::class.java)
        // TODO: Use the ViewModel
    }

}