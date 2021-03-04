package com.bsrakdg.mvvmrecipeapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bsrakdg.mvvmrecipeapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, RecipeListFragment())
            .commit()
    }
}
