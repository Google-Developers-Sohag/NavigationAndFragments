package com.example.last

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.last.databinding.FragmentBlankBinding


class BlankFragment : Fragment(R.layout.fragment_blank) {
    private lateinit var binding: FragmentBlankBinding
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // to init binding in fragments we use bind
        binding = FragmentBlankBinding.bind(view)
        // navController who controls the actions of navGraph
        navController = Navigation.findNavController(view)


        // to access the activity from any fragment we use:
        val activity = activity as MainActivity
        activity.supportActionBar?.hide()

        // we use "this" in activities but to access a context in fragment we use requireContext()
        Toast.makeText(requireContext(), "test", Toast.LENGTH_SHORT).show()

        binding.btnNext.setOnClickListener {

            navController.navigate(R.id.action_blankFragment_to_secondFragment)
        }

    }
}