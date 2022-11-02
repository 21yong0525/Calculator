package com.yong.yongcalculator

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.core.content.ContextCompat
import com.yong.yongcalculator.databinding.FtSettingBinding

class Setting : Fragment() {
    lateinit var binding: FtSettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    lateinit var mainActivity: MainActivity
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FtSettingBinding.inflate(inflater, container, false)

        setstatusBarColor()
        navigationBarColor()
        setBackgroundColor()

        return binding.root
    }


    fun setstatusBarColor() {
        binding.rbtnTop1.setOnClickListener {mainActivity.window.statusBarColor = ContextCompat.getColor(requireActivity(), R.color.black)}
        binding.rbtnTop2.setOnClickListener {mainActivity.window.statusBarColor = ContextCompat.getColor(requireActivity(), R.color.purple_200)}
        binding.rbtnTop3.setOnClickListener {mainActivity.window.statusBarColor = ContextCompat.getColor(requireActivity(), R.color.purple_500)}
        binding.rbtnTop4.setOnClickListener {mainActivity.window.statusBarColor = ContextCompat.getColor(requireActivity(), R.color.teal_200)}
        binding.rbtnTop5.setOnClickListener {mainActivity.window.statusBarColor = ContextCompat.getColor(requireActivity(), R.color.green)}
        binding.rbtnTop6.setOnClickListener {mainActivity.window.statusBarColor = ContextCompat.getColor(requireActivity(), R.color.blue)}
        binding.rbtnTop7.setOnClickListener {mainActivity.window.statusBarColor = ContextCompat.getColor(requireActivity(), R.color.orange)}
    }

    fun navigationBarColor() {
        binding.rbtnBot1.setOnClickListener {mainActivity.window.navigationBarColor = ContextCompat.getColor(requireActivity(), R.color.black)}
        binding.rbtnBot2.setOnClickListener {mainActivity.window.navigationBarColor = ContextCompat.getColor(requireActivity(), R.color.purple_200)}
        binding.rbtnBot3.setOnClickListener {mainActivity.window.navigationBarColor = ContextCompat.getColor(requireActivity(), R.color.purple_500)}
        binding.rbtnBot4.setOnClickListener {mainActivity.window.navigationBarColor = ContextCompat.getColor(requireActivity(), R.color.teal_200)}
        binding.rbtnBot5.setOnClickListener {mainActivity.window.navigationBarColor = ContextCompat.getColor(requireActivity(), R.color.green)}
        binding.rbtnBot6.setOnClickListener {mainActivity.window.navigationBarColor = ContextCompat.getColor(requireActivity(), R.color.blue)}
        binding.rbtnBot7.setOnClickListener {mainActivity.window.navigationBarColor = ContextCompat.getColor(requireActivity(), R.color.orange)}
    }

    fun setBackgroundColor() {
        binding.rbtnBack1.setOnClickListener {mainActivity.binding.drawerlayout.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.white))}
        binding.rbtnBack2.setOnClickListener {mainActivity.binding.drawerlayout.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.purple_200))}
        binding.rbtnBack3.setOnClickListener {mainActivity.binding.drawerlayout.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.purple_500))}
        binding.rbtnBack4.setOnClickListener {mainActivity.binding.drawerlayout.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.teal_200))}
        binding.rbtnBack5.setOnClickListener {mainActivity.binding.drawerlayout.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.green))}
        binding.rbtnBack6.setOnClickListener {mainActivity.binding.drawerlayout.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.blue))}
        binding.rbtnBack7.setOnClickListener {mainActivity.binding.drawerlayout.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.orange))}
    }

}