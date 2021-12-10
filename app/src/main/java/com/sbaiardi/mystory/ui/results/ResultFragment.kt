package com.sbaiardi.mystory.ui.results

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.sbaiardi.mystory.R
import com.sbaiardi.mystory.data.Result
import com.sbaiardi.mystory.data.Word
import com.sbaiardi.mystory.databinding.FragmentPlaceExtrationLayoutBinding
import com.sbaiardi.mystory.databinding.FragmentResultLayoutBinding
import com.sbaiardi.mystory.network.NameService
import com.sbaiardi.mystory.network.WordService
import com.sbaiardi.mystory.ui.extraction.ExtractionViewModel
import com.sbaiardi.mystory.utils.adapter.ResultAdapter
import com.sbaiardi.mystory.utils.adapter.TYPE_RESULT
import kotlinx.android.synthetic.main.fragment_result_layout.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ResultFragment: Fragment(R.layout.fragment_result_layout) {

    private lateinit var resultViewModel: ResultViewModel
    private var _binding: FragmentResultLayoutBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultLayoutBinding.inflate(inflater, container, false)
        resultViewModel =
            ViewModelProvider(this).get(ResultViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        val resultListAdapter = ResultAdapter{
            result -> adapterOnClick()
        }
        val layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )



        binding.recyclerResult.adapter = resultListAdapter
        binding.recyclerResult.layoutManager = layoutManager
        resultViewModel.getListResult()
        resultViewModel.results.observe(viewLifecycleOwner, {
            it.let {


                        binding.txtFirstCharacter.text = Result.result_first_character.name
                        binding.txtSecondCharacter.text = Result.result_second_character.name
                        binding.txtPlace.text = Result.result_place.name
                        resultListAdapter.submitList(it)
                        resultListAdapter.notifyDataSetChanged()
                        recycler_result.scrollToPosition(it.size-1)
                        println("and it seems to work!")



            }
        })
        binding.btnImprevisto.setOnClickListener {
            val event = NameService.killCharacter()
            val bundle = bundleOf(
                "type_result" to TYPE_RESULT.IMPREVISTO.name,
                "event" to event
            )
            Navigation.findNavController(binding.root).navigate(R.id.action_navigation_result_to_navigation_dialog, bundle)

            resultViewModel.getListResult()
        }

        binding.btnSuggerimento.setOnClickListener {
            val event = WordService.randomChoose()
            val bundle = bundleOf(
                "type_result" to TYPE_RESULT.SUGGERIMENTO.name,
                "event" to event.name
            )
            Navigation.findNavController(binding.root).navigate(R.id.action_navigation_result_to_navigation_dialog, bundle)
            resultViewModel.getListResult()

        }
    }

    override fun onDestroyView() {
        // Consider not storing the binding instance in a field, if not needed.
        _binding = null
        super.onDestroyView()
    }

    fun adapterOnClick(){}

}