package com.system.custom
import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.system.apputils.Utils


/**
 * Created by Bhavesh Hirpara on 25-05-2020
 */
public class CTextViewB : AppCompatTextView {

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context) : super(context) {
        init()
    }

    fun init() {
        if (!isInEditMode) {
            try {
                typeface = Utils.getBold(context)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}