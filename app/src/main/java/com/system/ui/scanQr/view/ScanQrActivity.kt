package com.system.ui.scanQr.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.system.R
import com.system.base.view.BaseActivity
import com.system.databinding.ActivityHomeBinding
import com.system.databinding.ActivityScanQrBinding
import com.system.ui.attendace.viewmodel.AttendanceViewModel
import com.system.ui.home.viewmodel.HomeViewModel
import com.system.ui.scanQr.viewmodel.ScanQrViewModel

class ScanQrActivity :BaseActivity() {
    lateinit var binding: ActivityScanQrBinding
    lateinit var viewModel: ScanQrViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(activity, R.color.white)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_scan_qr)
        viewModel = ViewModelProvider(activity).get(ScanQrViewModel::class.java)
        viewModel.setBinder(binding)
    }
}