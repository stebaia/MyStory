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
import com.sbaiardi.mystory.databinding.FragmentPlaceExtrationLayoutBinding
import com.sbaiardi.mystory.utils.adapter.TYPE_RESULT

class PlaceExtractionFragment: Fragment(R.layout.fragment_place_extration_layout) {
    private lateinit var extractionViewModel: ExtractionViewModel
    private var _binding: FragmentPlaceExtrationLayoutBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlaceExtrationLayoutBinding.inflate(inflater, container, false)
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
            extractionViewModel.getRandomPlace()
            binding.btnExtraction.visibility = View.GONE
            binding.btnNext.visibility = View.VISIBLE
        }

        extractionViewModel.place.observe(viewLifecycleOwner, {
            Result.result_place = it
            binding.txtNameLabel.text = "Il luogo estratto è ${it.name}"
        })

        binding.btnNext.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_navigation_place_extraction_to_navigation_result)
        }
    }

    override fun onDestroyView() {
        // Consider not storing the binding instance in a field, if not needed.
        _binding = null
        super.onDestroyView()
    }




}
