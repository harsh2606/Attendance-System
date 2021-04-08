package com.system.ui.studentdashboard.viewmodel

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.view.View
import com.system.R
import com.system.apputils.Utils
import com.system.base.viewmodel.BaseViewModel
import com.system.databinding.ActivityHomeBinding
import com.system.databinding.ActivityStudentBinding
import com.system.interfaces.TopBarClickListener
import com.system.ui.attendace.view.AttendanceActivity
import com.system.ui.qr.view.QrGenrateActivity
import com.system.ui.scanQr.view.ScanQrActivity

class StudentViewModel (application: Application) : BaseViewModel(application) {

    private lateinit var binder: ActivityStudentBinding
    private lateinit var mContext: Context

    fun setBinder(binder: ActivityStudentBinding) {
        this.binder = binder
        this.mContext = binder.root.context
        this.binder.viewModel = this
        this.binder.viewClickHandler = ViewClickHandler()
        this.binder.topbar.topBarClickListener = SlideMenuClickListener()
        this.binder.topbar.isTextShow = true
        this.binder.topbar.isBackShow = true
        this.binder.topbar.isCenterTextShow = true
        this.binder.topbar.tvTitleText.text = (mContext as Activity).getString(R.string.dashboard)

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
        fun onScanQr(view: View) {
            try {
                var intent = Intent(mContext, ScanQrActivity::class.java)
                mContext.startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun onAttendace(view: View) {
            try {
                var intent = Intent(mContext, AttendanceActivity::class.java)
                mContext.startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun onAssignment(view: View) {
//            try {
//                var intent = Intent(mContext, AboutYouActivity::class.java)
//                mContext.startActivity(intent)
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
        }

        fun onProfile(view: View) {
            try {
//                var intent = Intent(mContext, AboutYouActivity::class.java)
//                mContext.startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }


}