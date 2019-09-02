package com.pavelwinter.myorganizer.experimental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pavelwinter.myorganizer.R

class Experimental : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_experimental)


        supportFragmentManager .beginTransaction()
            .add(R.id.frameForFragment, ProjectsFragment())
            .commit()
    }
}
