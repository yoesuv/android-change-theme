package com.yoesuv.changetheme

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var theme: Boolean? = false

    override fun onCreate(savedInstanceState: Bundle?) {

        theme = App.prefHelper?.getBoolean(AppConstants.PREFERENCES_THEME_LIGHT_DARK)
        switchLightDarkTheme(theme)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.elevation = 8F

        setupSwitch()
    }

    private fun setupSwitch() {
        switchMain.isChecked = theme!!
        switchMain.setOnCheckedChangeListener { _: CompoundButton, b: Boolean ->
            App.prefHelper?.setBoolean(AppConstants.PREFERENCES_THEME_LIGHT_DARK, b)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun switchLightDarkTheme(value: Boolean?) {
        if (value!!) {
            setTheme(R.style.AppThemeDark)
        } else {
            setTheme(R.style.AppThemeLight)
        }
    }
}
