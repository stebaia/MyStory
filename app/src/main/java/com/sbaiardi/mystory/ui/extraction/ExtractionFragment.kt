package com.sbaiardi.mystory.ui.extraction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.sbaiardi.mystory.R
import com.sbaiardi.mystory.databinding.FragmentExtractionLayoutBinding
import com.sbaiardi.mystory.network.NameService
import com.sbaiardi.mystory.ui.dashboard.DashboardViewModel


class ExtractionFragment: Fragment(R.layout.fragment_extraction_layout) {
    private lateinit var extractionViewModel: ExtractionViewModel
    private var _binding: FragmentExtractionLayoutBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExtractionLayoutBinding.inflate(inflater, container, false)
        extractionViewModel =
            ViewModelProvider(this).get(ExtractionViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()

        binding.btnExtraction.setOnClickListener {
            extractionViewModel.name.observe(viewLifecycleOwner, {
                binding.txtNameResult.text = it
            })
            binding.btnNext.visibility = View.VISIBLE
        }

        binding.btnNext.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_navigation_extraction_to_navigation_second_name)
        }
    }

    override fun onDestroyView() {
        // Consider not storing the binding instance in a field, if not needed.
        _binding = null
        super.onDestroyView()
    }




}