package com.yong.yongcalculator

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayoutMediator
import com.yong.yongcalculator.databinding.ActivityMainBinding
import com.yong.yongcalculator.databinding.FtBasicsBinding


import com.yong.yongcalculator.databinding.UsertabButtonBinding

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var binding: ActivityMainBinding
    lateinit var basics: Basics
    lateinit var calculationList: CalculationList
    lateinit var setting: Setting

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //액션바대신에 툴바로 대체
        setSupportActionBar(binding.toolbar)
        //ActionBarDrawerToggle 버튼적용

        toggle = ActionBarDrawerToggle(
            this,
            binding.drawerlayout,
            R.string.drawer_open,
            R.string.drawer_close
        )

        //업버튼 활성화
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //토글 sync

        toggle.syncState()


        //어댑터를 생성
        val pageAdapter = PageAdapter(this)
        val titleList = mutableListOf<String>("계산","목록","설정")

        basics = Basics()
        calculationList = CalculationList()
        setting = Setting()

        pageAdapter.addFragment(basics,titleList[0])
        pageAdapter.addFragment(calculationList,titleList[1])
        pageAdapter.addFragment(setting,titleList[2])

        binding.viewpager2.adapter = pageAdapter

        //탭레이아웃 뷰페이저를 연동
        TabLayoutMediator(binding.tabLayout, binding.viewpager2){ tab, position ->
            tab.setCustomView(tabCreateView(titleList[position]))
        }.attach()

        binding.viewpager2.setCurrentItem(1)
        binding.viewpager2.setCurrentItem(0)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //이벤트가 토글버튼에서 발생하면
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return false
    }

    private fun tabCreateView(title: String): View {
        val usertabButtonBinding = UsertabButtonBinding.inflate(layoutInflater)
        usertabButtonBinding.tvTabName.text = title
        when (title){
            "계산" ->usertabButtonBinding.ivTabIcon.setImageResource(R.drawable.ic_calculate_24)
            "목록" ->usertabButtonBinding.ivTabIcon.setImageResource(R.drawable.ic_ist_alt_24)
            "설정" ->usertabButtonBinding.ivTabIcon.setImageResource(R.drawable.ic_settings_24)
        }
        return usertabButtonBinding.root
    }
}