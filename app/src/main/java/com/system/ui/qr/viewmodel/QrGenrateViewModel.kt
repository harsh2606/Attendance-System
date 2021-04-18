package com.system.ui.qr.viewmodel

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.system.R
import com.system.apputils.Utils
import com.system.base.viewmodel.BaseViewModel
import com.system.databinding.ActivityQrGenrateBinding
import com.system.databinding.ActivitySignupBinding
import com.system.interfaces.TopBarClickListener
import com.system.ui.login.view.LoginActivity
import com.system.validator.EmailValidator
import com.system.validator.PasswordValidator
import java.util.regex.Pattern

class QrGenrateViewModel (application: Application) : BaseViewModel(application),
    AdapterView.OnItemSelectedListener {

    private lateinit var binder: ActivityQrGenrateBinding
    private lateinit var mContext: Context

    fun setBinder(binder: ActivityQrGenrateBinding) {
        this.binder = binder
        this.mContext = binder.root.context
        this.binder.viewModel = this
        this.binder.viewClickHandler = ViewClickHandler()
        this.binder.topbar.topBarClickListener = SlideMenuClickListener()
        this.binder.topbar.isTextShow = true
        this.binder.topbar.isBackShow = true
        this.binder.topbar.isCenterTextShow= true
        this.binder.topbar.tvTitleText.text = (mContext as Activity).getString(R.string.qr)
        init()
    }

    private fun init() {
        val adapter = ArrayAdapter.createFromResource(
            mContext,
            R.array.items_spinner_add,
            R.layout.style_spinner_layout
        )
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout)
        binder.spinnerAdd.adapter = adapter
        binder.spinnerAdd.onItemSelectedListener = this

        selectPosition(0)
        try {

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun selectPosition(position: Int) {
        if (position == 0) {

        } else if (position == 1) {
        } else if (position == 2) {
        }
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

        }

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }


}
