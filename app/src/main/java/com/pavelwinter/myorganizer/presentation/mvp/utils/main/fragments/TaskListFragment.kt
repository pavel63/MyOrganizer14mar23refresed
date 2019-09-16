package com.pavelwinter.myorganizer.presentation.mvp.utils.main.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.pavelwinter.myorganizer.R
import com.pavelwinter.myorganizer.data.db.db_entities.ParentType
import com.pavelwinter.myorganizer.data.mocks.DataTypesGenerator
import com.pavelwinter.myorganizer.presentation.mvp.utils.main.adapters.TasksAdapter
import com.pavelwinter.myorganizer.presentation.mvp.utils.main.view_models.TaskListViewModel
import kotlinx.android.synthetic.main.task_list_fragment.*

class TaskListFragment : Fragment() {

    companion object {
        fun newInstance() = TaskListFragment()
    }

    private lateinit var viewModel: TaskListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.task_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TaskListViewModel::class.java)

        setupAdapter(DataTypesGenerator.generateParentList())
    }




    fun setupAdapter(itemsList : List<ParentType>){
        with(task_list_fragment_rv){
            adapter = TasksAdapter(itemsList)
            layoutManager = LinearLayoutManager(this@TaskListFragment.activity)
        }
    }

}
