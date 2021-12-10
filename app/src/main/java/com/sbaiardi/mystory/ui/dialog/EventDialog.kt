package com.sbaiardi.mystory.ui.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.sbaiardi.mystory.R
import com.sbaiardi.mystory.databinding.DialogEventLayoutBinding
import com.sbaiardi.mystory.databinding.FragmentExtractionLayoutBinding
import com.sbaiardi.mystory.ui.extraction.ExtractionViewModel
import com.sbaiardi.mystory.utils.adapter.TYPE_RESULT

class EventDialog: DialogFragment(R.layout.dialog_event_layout) {

    private var _binding: DialogEventLayoutBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DialogEventLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val type = requireArguments().getString("type_result")!!
        val description: String = requireArguments().getString("event")!!
        dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog!!.window!!.setLayout(width, height)


        binding.txtDescription.text = description

        if (TYPE_RESULT.valueOf(type) == TYPE_RESULT.IMPREVISTO){
            binding.txtTitle.text = "Nuovo Imprevisto!"
            binding.layoutContainer.setBackgroundResource(R.drawable.dialog_event_background)
        }else{
            binding.txtTitle.text = "Nuovo Consiglio!"
            binding.layoutContainer.setBackgroundResource(R.drawable.dialog_imprevisto_background)
        }

        binding.btnDismiss.setOnClickListener {
            dismiss()
        }



    }


}