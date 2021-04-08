package com.system.ui.studentdashboard.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.system.R
import com.system.base.view.BaseActivity
import com.system.databinding.ActivityHomeBinding
import com.system.databinding.ActivityStudentBinding
import com.system.ui.home.viewmodel.HomeViewModel
import com.system.ui.studentdashboard.viewmodel.StudentViewModel

class StudentActivity : BaseActivity() {
    lateinit var binding: ActivityStudentBinding
    lateinit var viewModel: StudentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(activity, R.color.white)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_student)
        viewModel = ViewModelProvider(activity).get(StudentViewModel::class.java)
        viewModel.setBinder(binding)
    }
}