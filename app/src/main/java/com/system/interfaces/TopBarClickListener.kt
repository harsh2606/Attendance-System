package com.system.interfaces

import android.view.View

interface TopBarClickListener {

    fun onTopBarClickListener(view: View?, value: String?)
    fun onBackClicked(view: View?)
}