package com.yong.yongcalculator

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yong.yongcalculator.databinding.FtBasicsBinding

class Basics : Fragment() {
    var cal = "0"
    var value1 : Any= 0
    var value2 : Any= 0
    var arithmetic = false
    lateinit var mainActivity: MainActivity
    lateinit var binding: FtBasicsBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FtBasicsBinding.inflate(inflater, container, false)

        binding.tv0.setOnClickListener { appendNumber(0) }
        binding.tv1.setOnClickListener { appendNumber(1) }
        binding.tv2.setOnClickListener { appendNumber(2) }
        binding.tv3.setOnClickListener { appendNumber(3) }
        binding.tv4.setOnClickListener { appendNumber(4) }
        binding.tv5.setOnClickListener { appendNumber(5) }
        binding.tv6.setOnClickListener { appendNumber(6) }
        binding.tv7.setOnClickListener { appendNumber(7) }
        binding.tv8.setOnClickListener { appendNumber(8) }
        binding.tv9.setOnClickListener { appendNumber(9) }
        binding.tvDivision.setOnClickListener { arithmeticIs("÷", binding) }
        binding.vtMultiplication.setOnClickListener { arithmeticIs("×", binding) }
        binding.tvMinus.setOnClickListener { arithmeticIs("-", binding) }
        binding.tvPlus.setOnClickListener { arithmeticIs("+", binding) }
        binding.tvIs.setOnClickListener { isValue(binding) }

        binding.tvSquare.setOnClickListener {
            if (binding.tvValue1.text.toString().toDouble() != 0.0 && binding.tvValue1.text.toString().isNotEmpty()){
                if (binding.tvValue1.text.toString().contains(".")) {
                    cal = "${binding.tvValue1.text.toString().toDouble()} x ${binding.tvValue1.text.toString().toDouble()}"
                    binding.tvValue1.text = String.format("%.2f", binding.tvValue1.text.toString().toDouble() * binding.tvValue1.text.toString().toDouble())
                } else {
                    cal = "${binding.tvValue1.text.toString().toLong()} x ${binding.tvValue1.text.toString().toLong()}"
                    binding.tvValue1.text = "${(binding.tvValue1.text.toString().toLong()*binding.tvValue1.text.toString().toLong())}"
                }
                binding.tvValue2.text = "0"
                binding.tvIsValue.text = binding.tvValue1.text.toString()

                setValue1TextSize(binding)
                binding.tvValue2.textSize = 34F
                setIsValueTextSize(binding)

                val dataVO: DataVO
                dataVO = DataVO(cal,binding.tvIsValue.text.toString())
                (mainActivity).calculationList.refreshRecyclerViewAdd(dataVO)
            }
        }

        binding.tvClear.setOnClickListener {
            value1 = 0
            value2 = 0
            arithmetic = false
            binding.tvValue2.text = "0"
            binding.tvValue1.text = "0"
            binding.tvArithmetic.text = "±"
            binding.tvIsValue.text = "0"
            binding.tvValue1.textSize = 34F
            binding.tvValue2.textSize = 34F
            binding.tvIsValue.textSize = 34F
        }

        binding.tvBack.setOnClickListener {
            if (!arithmetic){
                binding.tvValue1.text = binding.tvValue1.text.dropLast(1)
            } else {
                binding.tvValue2.text = binding.tvValue2.text.dropLast(1)
            }
            if (binding.tvValue1.text.equals("")){
                binding.tvValue1.text = "0"
            }
            if (binding.tvValue2.text.equals("")){
                binding.tvValue2.text = "0"
            }
            setValue1TextSize(binding)
            setValue2TextSize(binding)
        }

        binding.tvReal.setOnClickListener {
            if (!arithmetic){
                if (binding.tvValue1.text.length == 0){
                    binding.tvValue1.append("0.")
                } else if (!binding.tvValue1.text.toString().contains(".")){
                    binding.tvValue1.append(".")
                }
            } else {
                if (binding.tvValue2.text.length == 0){
                    binding.tvValue2.append("0.")
                } else if (binding.tvValue2.text.length != 0 &&!binding.tvValue2.text.toString().contains(".")){
                    binding.tvValue2.append(".")
                }
            }
            setValue1TextSize(binding)
            setValue2TextSize(binding)
        }
        return binding.root
    }

    fun appendNumber(num: Int) {
        if (!arithmetic){
            if (binding.tvValue1.text.toString().equals("0")){
                binding.tvValue1.text = "${num}"
            } else {
                binding.tvValue1.append("${num}")
            }
        } else {
            if (binding.tvValue2.text.toString().equals("0")){
                binding.tvValue2.text = "${num}"
            } else {
                binding.tvValue2.append("${num}")
            }
        }
        setValue1TextSize(binding)
        setValue2TextSize(binding)
    }

    fun arithmeticIs(arith : String, binding: FtBasicsBinding){
        if (binding.tvValue1.text.isNotEmpty()) {
            binding.tvArithmetic.text = arith
            arithmetic = true
        } else {
            binding.tvValue1.setText("")
            binding.tvArithmetic.text = arith
            arithmetic = true
        }
    }

    fun setValue1TextSize(binding: FtBasicsBinding){
        if (binding.tvValue1.text.length > 11) {
            binding.tvValue1.textSize = 26F
        } else if (binding.tvValue1.text.length > 9) {
            binding.tvValue1.textSize = 28F
        } else if (binding.tvValue1.text.length > 7) {
            binding.tvValue1.textSize = 30F
        } else if (binding.tvValue1.text.length > 5) {
            binding.tvValue1.textSize = 32F
        } else if (binding.tvValue1.text.length >= 0){
            binding.tvValue1.textSize = 34F
        }
    }

    fun setValue2TextSize(binding: FtBasicsBinding){
        if (binding.tvValue2.text.length > 11) {
            binding.tvValue2.textSize = 26F
        } else if (binding.tvValue2.text.length > 9) {
            binding.tvValue2.textSize = 28F
        } else if (binding.tvValue2.text.length > 7) {
            binding.tvValue2.textSize = 30F
        } else if (binding.tvValue2.text.length > 5) {
            binding.tvValue2.textSize = 32F
        } else if (binding.tvValue2.text.length >= 0){
            binding.tvValue2.textSize = 34F
        }
    }

    fun setIsValueTextSize(binding: FtBasicsBinding){
        if (binding.tvIsValue.text.length > 11) {
            binding.tvIsValue.textSize = 26F
        } else if (binding.tvIsValue.text.length > 9) {
            binding.tvIsValue.textSize = 28F
        } else if (binding.tvIsValue.text.length > 7) {
            binding.tvIsValue.textSize = 30F
        } else if (binding.tvIsValue.text.length > 5) {
            binding.tvIsValue.textSize = 32F
        } else if (binding.tvIsValue.text.length >= 0){
            binding.tvIsValue.textSize = 34F
        }
    }

    fun isValue(binding: FtBasicsBinding) {

        if (binding.tvValue2.length() != 0) {
            if (binding.tvValue1.text.toString().contains(".") || binding.tvValue2.text.toString().contains(".")){
                value1 = binding.tvValue1.text.toString().toDouble()
                value2 = binding.tvValue2.text.toString().toDouble()
            } else {
                value1 = binding.tvValue1.text.toString().toInt().toLong()
                value2 = binding.tvValue2.text.toString().toInt().toLong()
            }
            if (value2 != 0) {
                if (binding.tvValue1.text.toString().contains(".") || binding.tvValue2.text.toString().contains(".")
                ) {
                    when (binding.tvArithmetic.text) {
                        "÷" -> {
                            binding.tvIsValue.text = String.format("%.2f", value1.toString().toDouble() / value2.toString().toDouble())
                            cal = "${value1.toString().toDouble()} ÷ ${value2.toString().toDouble()} = "
                        }
                        "×" -> {
                            binding.tvIsValue.text = String.format("%.2f", value1.toString().toDouble() * value2.toString().toDouble())
                            cal = "${value1.toString().toDouble()} × ${value2.toString().toDouble()} = "
                        }
                        "-" -> {
                            binding.tvIsValue.text = String.format("%.2f", value1.toString().toDouble() - value2.toString().toDouble())
                            cal = "${value1.toString().toDouble()} - ${value2.toString().toDouble()} = "
                        }
                        "+" -> {
                            binding.tvIsValue.text = String.format("%.2f", value1.toString().toDouble() + value2.toString().toDouble())
                            cal = "${value1.toString().toDouble()} + ${value2.toString().toDouble()} = "
                        }
                    }
                } else {
                    when (binding.tvArithmetic.text) {
                        "÷" -> {
                            binding.tvIsValue.text = String.format("%.2f", value1.toString().toDouble() / value2.toString().toDouble())
                            cal = "${value1.toString().toDouble()} ÷ ${value2.toString().toDouble()} = "
                        }
                        "×" -> {
                            binding.tvIsValue.text = "${(value1.toString().toLong() * value2.toString().toLong())}"
                            cal = "${value1.toString().toLong()} × ${value2.toString().toLong()} = "
                        }
                        "-" -> {
                            binding.tvIsValue.text = "${(value1.toString().toLong() - value2.toString().toLong())}"
                            cal = "${value1.toString().toLong()} - ${value2.toString().toInt()} = "
                        }
                        "+" -> {
                            binding.tvIsValue.text = "${(value1.toString().toLong() + value2.toString().toLong())}"
                            cal = "${value1.toString().toLong()} + ${value2.toString().toLong()} = "
                        }
                    }
                }
                binding.tvValue1.text = binding.tvIsValue.text
                binding.tvIsValue.text = "= ${binding.tvIsValue.text}"
                binding.tvValue2.text = ""

                setValue1TextSize(binding)
                binding.tvValue2.textSize = 34F
                setIsValueTextSize(binding)

                val dataVO: DataVO
                dataVO = DataVO(cal,binding.tvIsValue.text.toString())
                (mainActivity).calculationList.refreshRecyclerViewAdd(dataVO)
            }
        }
    }
}
