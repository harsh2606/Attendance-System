package com.system.ui.qr.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.system.R
import com.system.base.view.BaseActivity
import com.system.databinding.ActivityHomeBinding
import com.system.databinding.ActivityQrGenrateBinding
import com.system.ui.home.viewmodel.HomeViewModel
import com.system.ui.qr.viewmodel.QrGenrateViewModel

class QrGenrateActivity : BaseActivity() {
    lateinit var binding: ActivityQrGenrateBinding
    lateinit var viewModel: QrGenrateViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_qr_genrate)
        viewModel = ViewModelProvider(activity).get(QrGenrateViewModel::class.java)
        viewModel.setBinder(binding)
    }
}