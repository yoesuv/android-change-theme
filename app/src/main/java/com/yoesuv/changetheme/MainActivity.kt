package com.yoesuv.changetheme

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
        setStatus()
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
            when (type) {
                "" -> { setTheme(R.style.AppThemeDark) }
                MyDarkTheme.ONE.name -> setTheme(R.style.AppThemeDarkOne)
                MyDarkTheme.TWO.name -> setTheme(R.style.AppThemeDarkTwo)
                MyDarkTheme.THREE.name -> setTheme(R.style.AppThemeDarkThree)
                else -> setTheme(R.style.AppThemeDark)
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

    private fun setStatus(){
        val type = App.prefHelper?.getString(AppConstants.PREFERENCES_THEME_DARK_VALUE)
        menuDarkDefault.setImageResource(R.drawable.round_default)
        menuDark1.setImageResource(R.drawable.round_blue_grey)
        menuDark2.setImageResource(R.drawable.round_blue_grey_2)
        menuDark3.setImageResource(R.drawable.round_blue_grey_3)
        when (type) {
            "" -> menuDarkDefault.setImageResource(R.drawable.round_default_selected)
            MyDarkTheme.ONE.name -> menuDark1.setImageResource(R.drawable.round_blue_grey_selected)
            MyDarkTheme.TWO.name -> menuDark2.setImageResource(R.drawable.round_blue_grey_2_selected)
            MyDarkTheme.THREE.name -> menuDark3.setImageResource(R.drawable.round_blue_grey_3_selected)
            else -> menuDarkDefault.setImageResource(R.drawable.round_default_selected)
        }
    }

}
