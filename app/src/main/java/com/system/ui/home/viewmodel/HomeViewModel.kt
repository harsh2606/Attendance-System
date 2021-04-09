package com.system.ui.home.viewmodel


import android.app.*
import android.content.Context
import android.content.Intent
import android.os.CountDownTimer
import android.provider.Settings.System.getString
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.system.R
import com.system.apputils.Utils
import com.system.base.viewmodel.BaseViewModel
import com.system.databinding.ActivityHomeBinding
import com.system.interfaces.TopBarClickListener
import com.system.ui.qr.view.QrGenrateActivity
import com.system.ui.studentattendace.view.StudentAttendanceActivity
import com.system.ui.studentdashboard.view.StudentActivity
import java.util.concurrent.TimeUnit
import kotlin.concurrent.timer


class HomeViewModel(application: Application) : BaseViewModel(application){

    private lateinit var binder: ActivityHomeBinding
    private lateinit var mContext: Context
    private var countDownTimer: CountDownTimer? = null
    var progressBarCircle: ProgressBar? = null
    var timeCountInMilliSeconds = (1 * 60000).toLong()


    fun setBinder(binder: ActivityHomeBinding) {
        this.binder = binder
        this.mContext = binder.root.context
        this.binder.viewModel = this
        this.binder.viewClickHandler = ViewClickHandler()
        init()
        setTimerValues()
    }

    private fun init() {
        countDownTimer = object : CountDownTimer(timeCountInMilliSeconds, 1000) {
            override fun onTick(millisUntilFinished: Long) {
               binder.textViewTime.text = hmsTimeFormatter(millisUntilFinished)
                progressBarCircle?.progress = (millisUntilFinished / 1000).toInt()
            }

            override fun onFinish() {
                TODO("Not yet implemented")
                //run please ai what happen thai nai thu.....
                progressBarCircle!!.max = timeCountInMilliSeconds.toInt() / 1000
                progressBarCircle!!.progress = timeCountInMilliSeconds.toInt() / 1000
            }


        }.start()
        countDownTimer!!.start()

    }

    fun hmsTimeFormatter(milliSeconds: Long): String {
        return String.format(
            "%02d:%02d:%02d",
            TimeUnit.MILLISECONDS.toHours(milliSeconds),
            TimeUnit.MILLISECONDS.toMinutes(milliSeconds) - TimeUnit.HOURS.toMinutes(
                TimeUnit.MILLISECONDS.toHours(
                    milliSeconds
                )
            ),
            TimeUnit.MILLISECONDS.toSeconds(milliSeconds) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(
                    milliSeconds
                )
            )
        )
    }


    private fun setTimerValues() {
        var time = 0
        if (!binder.editTextMinute.text.toString().isEmpty()) {
            time = binder.editTextMinute.text.toString().trim { it <= ' ' }.toInt()
        } else {
            Toast.makeText(
               mContext, "Hansu" ,Toast.LENGTH_LONG
            ).show()
        }
        timeCountInMilliSeconds = (time * 60 * 1000).toLong()
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
                var intent = Intent(mContext, QrGenrateActivity::class.java)
                mContext.startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun onAttendace(view: View) {
            try {
                var intent = Intent(mContext, StudentAttendanceActivity::class.java)
                mContext.startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun onAssignment(view: View) {
            try {
                var intent = Intent(mContext, StudentActivity::class.java)
                mContext.startActivity(intent)
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



