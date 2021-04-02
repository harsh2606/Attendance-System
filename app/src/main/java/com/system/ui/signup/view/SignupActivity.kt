package com.system.ui.signup.view

import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.system.R
import com.system.base.view.BaseActivity
import com.system.databinding.ActivityLoginBinding
import com.system.databinding.ActivitySignupBinding
import com.system.ui.signup.viewmodel.SignUpViewModel

class SignupActivity : BaseActivity() {
    lateinit var binding: ActivitySignupBinding
    lateinit var viewModel: SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(activity, R.color.white)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup)
        viewModel = ViewModelProvider(activity).get(SignUpViewModel::class.java)
        viewModel.setBinder(binding)
    }
}