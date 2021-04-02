package com.system.ui.emaillogin.view

import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.system.R
import com.system.base.view.BaseActivity
import com.system.databinding.ActivityEmailLoginBinding
import com.system.databinding.ActivitySignupBinding
import com.system.ui.emaillogin.viewmodel.EmailLoginViewModel

class EmailLoginActivity : BaseActivity() {
    lateinit var binding: ActivityEmailLoginBinding
    lateinit var viewModel: EmailLoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(activity, R.color.white)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_email_login)
        viewModel = ViewModelProvider(activity).get(EmailLoginViewModel::class.java)
        viewModel.setBinder(binding)
    }
}