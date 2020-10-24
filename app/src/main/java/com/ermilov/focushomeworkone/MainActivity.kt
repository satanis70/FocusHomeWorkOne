package com.ermilov.focushomeworkone

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.ermilov.focushomeworkone.task1.FragmentA

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_activity, MainFragment.newInstanse())
                .commit()
        }


    }
}