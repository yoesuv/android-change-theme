package com.yoesuv.changetheme

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        setupSwitch()
    }

    private fun setupSwitch(){
        switchMain.setOnCheckedChangeListener { _: CompoundButton, b: Boolean ->
            Log.d(AppConstants.RESULT_DEBUG,"MainActivity # setupSwitch $b")
            if (b) {
                setTheme(R.style.AppThemeLight)
            } else {
                setTheme(R.style.AppThemeDark)
            }

        }
    }
}
