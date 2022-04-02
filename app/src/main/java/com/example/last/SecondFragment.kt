package com.example.last

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.last.databinding.FragmentSecondBinding

// don't forget to set xml design source in Fragment() class
class SecondFragment : Fragment(R.layout.fragment_second) {
    private lateinit var binding: FragmentSecondBinding
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSecondBinding.bind(view)
        navController = Navigation.findNavController(view)


        binding.btnPrevious.setOnClickListener {
            navController.navigate(R.id.action_secondFragment_to_blankFragment)
        }
        binding.imageView.setOnClickListener { selectImageFromGallery() }
    }

    // to select an image from gallery
    private val selectImageFromGalleryResult =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri ->
            binding.imageView.setImageURI(uri)
        }

    // image/* --> gets all images jpg, png..etc
    private fun selectImageFromGallery() = selectImageFromGalleryResult.launch("image/*")


}