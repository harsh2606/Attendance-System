package com.system.ui.resetpassword.view

import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.system.R
import com.system.base.view.BaseActivity
import com.system.databinding.ActivityForgotPasswordBinding
import com.system.databinding.ActivityResetPasswordBinding
import com.system.ui.resetpassword.viewmodel.ResetPasswordViewModel

class ResetPasswordActivity :BaseActivity() {
    lateinit var binding: ActivityResetPasswordBinding
    lateinit var viewModel: ResetPasswordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(activity, R.color.white)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_reset_password)
        viewModel = ViewModelProvider(activity).get(ResetPasswordViewModel::class.java)
        viewModel.setBinder(binding)
    }
}