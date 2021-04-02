package com.system.ui.forgotpassword.view

import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.system.R
import com.system.base.view.BaseActivity
import com.system.databinding.ActivityForgotPasswordBinding
import com.system.databinding.ActivitySignupBinding
import com.system.ui.forgotpassword.viewmodel.ForgotPasswordViewModel

class ForgotPasswordActivity : BaseActivity() {
    lateinit var binding: ActivityForgotPasswordBinding
    lateinit var viewModel: ForgotPasswordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(activity, R.color.white)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_forgot_password)
        viewModel = ViewModelProvider(activity).get(ForgotPasswordViewModel::class.java)
        viewModel.setBinder(binding)
    }
}