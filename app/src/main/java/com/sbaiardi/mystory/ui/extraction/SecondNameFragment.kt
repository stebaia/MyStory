package com.sbaiardi.mystory.ui.extraction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.sbaiardi.mystory.R
import com.sbaiardi.mystory.data.Result
import com.sbaiardi.mystory.databinding.FragmentExtractionLayoutBinding
import com.sbaiardi.mystory.databinding.FragmentSecondNameLayoutBinding
import com.sbaiardi.mystory.utils.adapter.TYPE_RESULT

class SecondNameFragment: Fragment(R.layout.fragment_second_name_layout) {

    private lateinit var extractionViewModel: ExtractionViewModel
    private var _binding: FragmentSecondNameLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondNameLayoutBinding.inflate(inflater, container, false)
        extractionViewModel =
            ViewModelProvider(this).get(ExtractionViewModel::class.java)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.btnExtraction.setOnClickListener {
            extractionViewModel.getRandomName()
            binding.btnExtraction.visibility = View.GONE
            binding.btnNext.visibility = View.VISIBLE
        }
        extractionViewModel.name.observe(viewLifecycleOwner, {

            Result.result_second_character = it

            binding.txtNameLabel.text = "Il personaggio estratto è ${it.name}"
        })
        binding.btnNext.setOnClickListener {
            Navigation.findNavController(binding.root)
                .navigate(R.id.action_navigation_second_name_to_navigation_place_extraction)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}