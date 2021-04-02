package com.system.ui.forgotpassword.viewmodel

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.view.View
import com.system.R
import com.system.apputils.Utils
import com.system.base.viewmodel.BaseViewModel
import com.system.databinding.ActivityForgotPasswordBinding
import com.system.databinding.ActivitySignupBinding
import com.system.interfaces.TopBarClickListener
import com.system.ui.resetpassword.view.ResetPasswordActivity
import com.system.validator.EmailValidator
import com.system.validator.PasswordValidator

class ForgotPasswordViewModel (application: Application) : BaseViewModel(application) {

    private lateinit var binder: ActivityForgotPasswordBinding
    private lateinit var mContext: Context

    fun setBinder(binder: ActivityForgotPasswordBinding) {
        this.binder = binder
        this.mContext = binder.root.context
        this.binder.viewModel = this
        this.binder.viewClickHandler = ViewClickHandler()
        this.binder.topbar.topBarClickListener = SlideMenuClickListener()
        this.binder.topbar.isTextShow = true
        this.binder.topbar.isBackShow = true
        this.binder.topbar.isCenterTextShow= true
        this.binder.topbar.tvTitleText.text = (mContext as Activity).getString(R.string.forgot_password1)
        init()
    }

    private fun init() {

    }

    inner class SlideMenuClickListener : TopBarClickListener {
        override fun onTopBarClickListener(view: View?, value: String?) {
            Utils.hideKeyBoard(getContext(), view!!)
            if (value.equals(getLabelText(R.string.menu))) {
                try {
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            if (value.equals(getLabelText(R.string.back))) {
                try {
                    (mContext as Activity).finish()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

        override fun onBackClicked(view: View?) {
            (mContext as Activity).finish()
        }
    }


    inner class ViewClickHandler {

        fun onNext(view: View) {
            try {
                if (isValidate()) {
                    var intent = Intent(mContext, ResetPasswordActivity::class.java)
                    mContext.startActivity(intent)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

    fun isValidate(): Boolean {
        val emailValidator = EmailValidator(binder.edtEmail.text.toString())
        if (binder.edtEmail.text.toString().isNullOrEmpty()) {
            showToast(mContext.getString(R.string.email))
            return false
        }
        return true
    }
}
