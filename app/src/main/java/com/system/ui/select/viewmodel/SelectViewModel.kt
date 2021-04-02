package com.system.ui.select.viewmodel

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.view.View
import com.system.R
import com.system.apputils.Utils
import com.system.base.viewmodel.BaseViewModel
import com.system.databinding.ActivitySelectBinding
import com.system.databinding.ActivitySignupBinding
import com.system.interfaces.TopBarClickListener
import com.system.ui.home.view.HomeActivity
import com.system.ui.signup.view.SignupActivity

class SelectViewModel (application: Application) : BaseViewModel(application) {

    private lateinit var binder: ActivitySelectBinding
    private lateinit var mContext: Context

    fun setBinder(binder: ActivitySelectBinding) {
        this.binder = binder
        this.mContext = binder.root.context
        this.binder.viewModel = this
        this.binder.viewClickHandler = ViewClickHandler()
        this.binder.topbar.topBarClickListener = SlideMenuClickListener()
        this.binder.topbar.isTextShow = true
        this.binder.topbar.isBackShow = true
        this.binder.topbar.isCenterTextShow= true
        this.binder.topbar.tvTitleText.text = (mContext as Activity).getString(R.string.select_user)
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

        fun onStudent(view: View) {
            try {
                var intent = Intent(mContext, SignupActivity::class.java)
                mContext.startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun onProf(view: View) {
            try {
                var intent = Intent(mContext, SignupActivity::class.java)
                mContext.startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }
}
