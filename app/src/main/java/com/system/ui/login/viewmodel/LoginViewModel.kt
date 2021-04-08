package com.system.ui.login.viewmodel

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.view.View
import com.mikhaellopez.circularprogressbar.CircularProgressBar
import com.system.R
import com.system.apputils.Utils
import com.system.base.viewmodel.BaseViewModel
import com.system.databinding.ActivityLoginBinding
import com.system.interfaces.TopBarClickListener
import com.system.ui.emaillogin.view.EmailLoginActivity
import com.system.ui.forgotpassword.view.ForgotPasswordActivity
import com.system.ui.home.view.HomeActivity
import com.system.ui.select.view.SelectActivity
import com.system.ui.signup.view.SignupActivity
import com.system.validator.EmailValidator
import com.system.validator.PasswordValidator

class LoginViewModel(application: Application) : BaseViewModel(application) {

    private lateinit var binder: ActivityLoginBinding
    private lateinit var mContext: Context

    fun setBinder(binder: ActivityLoginBinding) {
        this.binder = binder
        this.mContext = binder.root.context
        this.binder.viewModel = this
        this.binder.viewClickHandler = ViewClickHandler()
        this.binder.topbar.topBarClickListener = SlideMenuClickListener()
        this.binder.topbar.isTextShow = true
        this.binder.topbar.isBackShow = true
        this.binder.topbar.isCenterTextShow= true
        this.binder.topbar.tvTitleText.text = (mContext as Activity).getString(R.string.login)
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

        fun onSignup(view: View) {
            try {
                var intent = Intent(mContext, SelectActivity::class.java)
                mContext.startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }



        fun onLogin(view: View) {
            try {
                if (isValidate()) {
                    var intent = Intent(mContext, HomeActivity::class.java)
                    mContext.startActivity(intent)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun  onForgotPassword(view: View) {
            try {
                var intent = Intent(mContext, ForgotPasswordActivity::class.java)
                mContext.startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

    fun isValidate(): Boolean {
        val emailValidator = EmailValidator(binder.edtEmail.text.toString())
        val passwordValidator = PasswordValidator(mContext, binder.edtPw.text.toString())
        if (binder.edtEmail.text.toString().isNullOrEmpty()) {
            showToast(mContext.getString(R.string.email))
            return false
        } else if (binder.edtPw.text.toString().isNullOrEmpty()) {
            showToast(mContext.getString(R.string.pw))
            return false
        }
        return true
    }




}
