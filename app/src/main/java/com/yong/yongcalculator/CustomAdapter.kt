package com.yong.yongcalculator

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.yong.yongcalculator.databinding.ItemCalculationlistBinding

class CustomAdapter(val dataList: MutableList<DataVO>): RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = ItemCalculationlistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val customViewHolder = CustomViewHolder(binding)

        customViewHolder.itemView.setOnClickListener {
            val position: Int = customViewHolder.bindingAdapterPosition
            val dataVO = dataList.get(position)
            Toast.makeText(parent.context, "${dataVO.value1_2} = ${dataVO.isValue}", Toast.LENGTH_SHORT).show()
        }

        customViewHolder.itemView.setOnLongClickListener {
            val position: Int = customViewHolder.bindingAdapterPosition
            val dataVO = dataList.get(position)
            (parent.context as MainActivity).calculationList.refreshRecyclerViewDrop(dataVO)
            true
        }

        return customViewHolder
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val binding = (holder as CustomViewHolder).binding
        val dataVO = dataList.get(position)
        binding.itemValue12.text = dataVO.value1_2
        binding.itemIsValue.text = dataVO.isValue
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class CustomViewHolder(val binding : ItemCalculationlistBinding): RecyclerView.ViewHolder(binding.root)
}