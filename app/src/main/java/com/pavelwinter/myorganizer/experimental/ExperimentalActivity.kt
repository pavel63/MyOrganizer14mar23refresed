package com.pavelwinter.myorganizer.experimental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pavelwinter.myorganizer.R
import com.pavelwinter.myorganizer.presentation.mvp.utils.main.fragments.Forms.AddTaskFragment

class ExperimentalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_experimental)


        supportFragmentManager .beginTransaction()
            .add(R.id.frameForFragment, AddTaskFragment())
            .commit()
    }
}
