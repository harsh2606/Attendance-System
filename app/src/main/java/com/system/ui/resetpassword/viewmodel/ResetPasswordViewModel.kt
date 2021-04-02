package com.system.ui.resetpassword.viewmodel

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.content.ContextCompat
import com.system.R
import com.system.apputils.Utils
import com.system.base.viewmodel.BaseViewModel
import com.system.databinding.ActivityForgotPasswordBinding
import com.system.databinding.ActivityResetPasswordBinding
import com.system.interfaces.TopBarClickListener
import com.system.ui.emaillogin.view.EmailLoginActivity
import com.system.ui.login.view.LoginActivity
import com.system.validator.EmailValidator

class ResetPasswordViewModel (application: Application) : BaseViewModel(application) {

    private lateinit var binder: ActivityResetPasswordBinding
    private lateinit var mContext: Context

    fun setBinder(binder: ActivityResetPasswordBinding) {
        this.binder = binder
        this.mContext = binder.root.context
        this.binder.viewModel = this
        this.binder.viewClickHandler = ViewClickHandler()
        this.binder.topbar.topBarClickListener = SlideMenuClickListener()
        this.binder.topbar.isTextShow = true
        this.binder.topbar.isBackShow = true
        this.binder.topbar.isCenterTextShow= true
        this.binder.topbar.tvTitleText.text = (mContext as Activity).getString(R.string.reset_password1)
        init()
    }

    private fun init() {

        binder.edtCpw.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                try {

                    if (p0?.length!! > 7) {

                        if (binder.edtCpw.text.toString() == binder.edtPw.text.toString()){


                            binder.tvPasswordError.visibility = View.GONE


//                    der.tvConfirm.setTextColor(ContextCompat.getColor(mContext, R.color.white))
                        }
                    }else {
                        binder.tvPasswordError.visibility = View.VISIBLE
//                        binder.btnConfirm.background = (
//                                ContextCompat.getDrawable(
//                                        mContext,
//                                        R.drawable.border_add_credit_gray
//                                )
//                                )
//                        binder.cvConfirm.setCardBackgroundColor(
//                            ContextCompat.getColor(
//                                mContext,
//                                R.color.gray_59
//                            )
//                        )
//                        binder.tvConfirm.setTextColor(ContextCompat.getColor(mContext, R.color.white))
                    }


                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

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

        fun onDone(view: View) {
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
         if (binder.edtPw.text.toString().isNullOrEmpty() || binder.edtPw.text.toString().length < 8 ) {
            showToast(mContext.getString(R.string.pw))
            return false
        } else if (binder.edtCpw.text.toString().isNullOrEmpty() || binder.edtCpw.text.toString().length < 8 ) {
            showToast(mContext.getString(R.string.cpw))
            return false
        }  else if(binder.edtCpw.text.toString() != binder.edtPw.text.toString()){
            showToast(mContext.getString(R.string.password_validation))
            return false
        }
        return true
    }

}
