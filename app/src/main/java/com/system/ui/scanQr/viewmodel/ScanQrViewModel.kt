package com.system.ui.scanQr.viewmodel

import android.app.Activity
import android.app.Application
import android.content.Context
import android.view.View
import com.system.R
import com.system.apputils.Utils
import com.system.base.viewmodel.BaseViewModel
import com.system.databinding.ActivityAttendanceBinding
import com.system.databinding.ActivityScanQrBinding
import com.system.interfaces.TopBarClickListener

class ScanQrViewModel (application: Application) : BaseViewModel(application) {

    private lateinit var binder: ActivityScanQrBinding
    private lateinit var mContext: Context

    fun setBinder(binder: ActivityScanQrBinding) {
        this.binder = binder
        this.mContext = binder.root.context
        this.binder.viewModel = this
        this.binder.viewClickHandler = ViewClickHandler()
        this.binder.topbar.topBarClickListener = SlideMenuClickListener()
        this.binder.topbar.isTextShow = true
        this.binder.topbar.isBackShow = true
        this.binder.topbar.isCenterTextShow = true
        this.binder.topbar.tvTitleText.text = (mContext as Activity).getString(R.string.Scanqr)
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
    }
}
