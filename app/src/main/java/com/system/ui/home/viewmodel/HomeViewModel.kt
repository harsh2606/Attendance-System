package com.system.ui.home.viewmodel


import android.app.*
import android.content.Context
import android.content.Intent
import android.view.View
import com.system.R
import com.system.apputils.Utils
import com.system.base.viewmodel.BaseViewModel
import com.system.databinding.ActivityHomeBinding
import com.system.interfaces.TopBarClickListener


class HomeViewModel(application: Application) : BaseViewModel(application){

    private lateinit var binder: ActivityHomeBinding
    private lateinit var mContext: Context


    fun setBinder(binder: ActivityHomeBinding) {
        this.binder = binder
        this.mContext = binder.root.context
        this.binder.viewModel = this
        this.binder.viewClickHandler = ViewClickHandler()

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
        }

        override fun onBackClicked(view: View?) {
            (mContext as Activity).finish()
        }
    }


    inner class ViewClickHandler {

        fun onQr(view: View) {
            try {
//                var intent = Intent(mContext, QrGenrateActivity::class.java)
//                mContext.startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun onAttendace(view: View) {
            try {
//                var intent = Intent(mContext, StudentAttendanceActivity::class.java)
//                mContext.startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun onAssignment(view: View) {
            try {
//                var intent = Intent(mContext, StudentActivity::class.java)
//                mContext.startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun onProfile(view: View) {
//            try {
//                var intent = Intent(mContext, AboutYouActivity::class.java)
//                mContext.startActivity(intent)
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
        }





    }


}



