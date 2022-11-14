package com.yong.yongcalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.yong.yongcalculator.databinding.FtCalculationlistBinding

class CalculationList : Fragment() {
    lateinit var binding: FtCalculationlistBinding
    var dataList = mutableListOf<DataVO>()
    lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FtCalculationlistBinding.inflate(inflater, container, false)

        val linearLayoutManager = LinearLayoutManager(container?.context)
        customAdapter = CustomAdapter(dataList)
        binding.ftCalListRecyclerView.layoutManager = linearLayoutManager
        binding.ftCalListRecyclerView.adapter = customAdapter
        binding.ftCalListRecyclerView.addItemDecoration(MyDecoration())

        return binding.root
    }

    fun refreshRecyclerViewAdd(dataVO: DataVO) {
        dataList.add(dataVO)
        customAdapter.notifyDataSetChanged()
    }
    
    fun refreshRecyclerViewDrop(dataVO: DataVO) {
        Toast.makeText(binding.root.context,"해당 목록을 삭제합니다", Toast.LENGTH_SHORT).show()
        dataList.remove(dataVO)
        customAdapter.notifyDataSetChanged()
    }
}