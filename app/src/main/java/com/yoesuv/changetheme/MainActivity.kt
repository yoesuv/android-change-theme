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
        switchDarkTheme()
    }

    private fun setupSwitch() {
        switchMain.isChecked = theme!!
        switchMain.setOnCheckedChangeListener { _: CompoundButton, b: Boolean ->
            App.prefHelper?.setBoolean(AppConstants.PREFERENCES_THEME_LIGHT_DARK, b)
            recreate()
        }
    }

    private fun switchLightDarkTheme(value: Boolean?) {
        if (value!!) {
            val type = App.prefHelper?.getString(AppConstants.PREFERENCES_THEME_DARK_VALUE)
            if (type=="") {
                setTheme(R.style.AppThemeDark)
            } else if (type == MyDarkTheme.ONE.name) {
                setTheme(R.style.AppThemeDarkOne)
            } else if (type == MyDarkTheme.TWO.name){
                setTheme(R.style.AppThemeDarkTwo)
            } else {
                setTheme(R.style.AppThemeDark)
            }
        } else {
            setTheme(R.style.AppThemeLight)
        }
    }

    private fun switchDarkTheme(){
        if (theme!!) {
            menuDarkDefault.setOnClickListener {
                App.prefHelper?.setString(AppConstants.PREFERENCES_THEME_DARK_VALUE, MyDarkTheme.DEFAULT.name)
                setTheme(R.style.AppThemeDark)
                recreate()
            }
            menuDark1.setOnClickListener {
                App.prefHelper?.setString(AppConstants.PREFERENCES_THEME_DARK_VALUE, MyDarkTheme.ONE.name)
                setTheme(R.style.AppThemeDarkOne)
                recreate()
            }
            menuDark2.setOnClickListener {
                App.prefHelper?.setString(AppConstants.PREFERENCES_THEME_DARK_VALUE, MyDarkTheme.TWO.name)
                setTheme(R.style.AppThemeDarkTwo)
                recreate()
            }
            menuDark3.setOnClickListener {
                App.prefHelper?.setString(AppConstants.PREFERENCES_THEME_DARK_VALUE, MyDarkTheme.THREE.name)
                setTheme(R.style.AppThemeDarkThree)
                recreate()
            }
        }
    }
}
