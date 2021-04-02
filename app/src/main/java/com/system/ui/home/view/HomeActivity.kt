package com.system.ui.home.view

import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.system.R
import com.system.base.view.BaseActivity
import com.system.databinding.ActivityHomeBinding
import com.system.ui.home.viewmodel.HomeViewModel



class HomeActivity : BaseActivity() {
    lateinit var binding: ActivityHomeBinding
    lateinit var viewModel: HomeViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(activity, R.color.white)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        viewModel = ViewModelProvider(activity).get(HomeViewModel::class.java)
        viewModel.setBinder(binding)
    }

}
