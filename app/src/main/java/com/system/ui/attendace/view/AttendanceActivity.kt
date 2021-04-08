package com.system.ui.attendace.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.system.R
import com.system.base.view.BaseActivity
import com.system.databinding.ActivityAttendanceBinding
import com.system.databinding.ActivityHomeBinding
import com.system.ui.attendace.viewmodel.AttendanceViewModel
import com.system.ui.home.viewmodel.HomeViewModel

class AttendanceActivity : BaseActivity() {
    lateinit var binding: ActivityAttendanceBinding
    lateinit var viewModel: AttendanceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(activity, R.color.white)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_attendance)
        viewModel = ViewModelProvider(activity).get(AttendanceViewModel::class.java)
        viewModel.setBinder(binding)
    }
}