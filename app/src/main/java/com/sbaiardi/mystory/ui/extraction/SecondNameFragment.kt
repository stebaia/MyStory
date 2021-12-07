package com.sbaiardi.mystory.ui.extraction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.sbaiardi.mystory.databinding.FragmentExtractionLayoutBinding
import com.sbaiardi.mystory.databinding.FragmentSecondNameLayoutBinding

class SecondNameFragment: Fragment() {

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
            extractionViewModel.name.observe(viewLifecycleOwner, {
                binding.txtNameResult.text = it
            })
            binding.btnNext.visibility = View.VISIBLE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}