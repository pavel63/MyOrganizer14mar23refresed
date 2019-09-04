package com.pavelwinter.myorganizer.presentation.mvp.utils.main.fragments.Forms


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.pavelwinter.myorganizer.R

/**
 * A simple [Fragment] subclass.
 */
class AddTaskFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_task_form,container,false)
    }

}
