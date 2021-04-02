package com.system.ui.signup.viewmodel

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.view.View
import com.system.R
import com.system.apputils.Utils
import com.system.base.viewmodel.BaseViewModel
import com.system.databinding.ActivityLoginBinding
import com.system.databinding.ActivitySignupBinding
import com.system.interfaces.TopBarClickListener
import com.system.ui.home.view.HomeActivity
import com.system.ui.login.view.LoginActivity
import com.system.validator.EmailValidator
import com.system.validator.PasswordValidator
import java.util.regex.Pattern

class SignUpViewModel (application: Application) : BaseViewModel(application) {

    private lateinit var binder: ActivitySignupBinding
    private lateinit var mContext: Context

    fun setBinder(binder: ActivitySignupBinding) {
        this.binder = binder
        this.mContext = binder.root.context
        this.binder.viewModel = this
        this.binder.viewClickHandler = ViewClickHandler()
        this.binder.topbar.topBarClickListener = SlideMenuClickListener()
        this.binder.topbar.isTextShow = true
        this.binder.topbar.isBackShow = true
        this.binder.topbar.isCenterTextShow= true
        this.binder.topbar.tvTitleText.text = (mContext as Activity).getString(R.string.sign_up)
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
                    var intent = Intent(mContext, LoginActivity::class.java)
                    mContext.startActivity(intent)
                }
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
        } else if (binder.edtUser.text.toString().isNullOrEmpty()) {
            showToast(mContext.getString(R.string.user))
            return false
        } else if (binder.edtPw.text.toString().isNullOrEmpty()) {
            showToast(mContext.getString(R.string.pw))
            return false
        }else if (binder.edtContact.text.toString().isNullOrEmpty()) {
            showToast(mContext.getString(R.string.phone))
            return false
        } else if (binder.edtGanral.text.toString().isNullOrEmpty()) {
            showToast(mContext.getString(R.string.Genral))
            return false
        }
        return true
    }

    private fun isValidMobile(phone: String): Boolean {
        return if (!Pattern.matches("[a-zA-Z]+", phone)) {
            phone.length > 6 && phone.length <= 13
        } else false
    }
}
