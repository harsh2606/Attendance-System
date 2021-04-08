package com.system.ui.studentattendace.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.system.R
import com.system.base.view.BaseActivity
import com.system.databinding.ActivityQrGenrateBinding
import com.system.databinding.ActivityStudentAttendanceBinding
import com.system.ui.qr.viewmodel.QrGenrateViewModel
import com.system.ui.studentattendace.viewmodel.StudentAttendanceViewModel

class StudentAttendanceActivity : BaseActivity() {
    lateinit var binding: ActivityStudentAttendanceBinding
    lateinit var viewModel: StudentAttendanceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(activity, R.color.white)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_student_attendance)
        viewModel = ViewModelProvider(activity).get(StudentAttendanceViewModel::class.java)
        viewModel.setBinder(binding)
    }
}