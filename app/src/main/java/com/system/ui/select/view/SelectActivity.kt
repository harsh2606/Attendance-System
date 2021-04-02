package com.system.ui.select.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.system.R
import com.system.base.view.BaseActivity
import com.system.databinding.ActivitySelectBinding
import com.system.databinding.ActivitySignupBinding
import com.system.ui.select.viewmodel.SelectViewModel
import com.system.ui.signup.viewmodel.SignUpViewModel

class SelectActivity : BaseActivity() {
    lateinit var binding: ActivitySelectBinding
    lateinit var viewModel: SelectViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(activity, R.color.white)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_select)
        viewModel = ViewModelProvider(activity).get(SelectViewModel::class.java)
        viewModel.setBinder(binding)
    }
}