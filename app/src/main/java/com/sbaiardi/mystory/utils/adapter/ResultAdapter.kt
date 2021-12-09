package com.sbaiardi.mystory.utils.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sbaiardi.mystory.R
import com.sbaiardi.mystory.data.Result

class ResultAdapter(private val onClick: (Result) -> Unit): ListAdapter<Result, ResultAdapter.ViewHolder>(BeerDiffCallback) {
    class ViewHolder(view: View, val onClick: (Result) -> Unit): RecyclerView.ViewHolder(view) {
        private val textViewName: TextView = view.findViewById(R.id.txt_name_result)
        private val txtTypeResult: TextView = view.findViewById(R.id.txt_type)
        private val relativeBackground: RelativeLayout = view.findViewById(R.id.relative_background)
        lateinit var result: Result
        init {
            view.setOnClickListener {
                onClick(result)
            }
        }
        fun bind(result: Result){
            this.result = result
            textViewName.text = result.name
            when(result.type){
                TYPE_RESULT.ESTRAZIONE -> {
                    txtTypeResult.text = "Risultati Estrazione"
                    relativeBackground.setBackgroundResource(R.color.teal_200)
                }
                TYPE_RESULT.IMPREVISTO -> {
                    txtTypeResult.text = "Imprevisto!"
                    relativeBackground.setBackgroundResource(R.color.purple_700)
                }
                TYPE_RESULT.SUGGERIMENTO -> {
                    txtTypeResult.text = "Suggerimento!"
                    relativeBackground.setBackgroundResource(R.color.purple_200)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.items_result_layout,parent,false)
        return ViewHolder(view,onClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val municipality = getItem(position)
        holder.bind(municipality)

    }
}
object BeerDiffCallback : DiffUtil.ItemCallback<Result>() {
    override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem.name == newItem.name
    }
}



