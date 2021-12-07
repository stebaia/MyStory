package com.sbaiardi.mystory.ui.extraction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sbaiardi.mystory.databinding.FragmentExtractionLayoutBinding
import com.sbaiardi.mystory.databinding.FragmentSecondNameLayoutBinding

class SecondNameFragment: Fragment() {


    private var _binding: FragmentSecondNameLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondNameLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}