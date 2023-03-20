package com.pavelwinter.myorganizer.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.pavelwinter.myorganizer.data.db.db_entities.ParentType
import com.pavelwinter.myorganizer.data.mocks.DataTypesGenerator
import com.pavelwinter.myorganizer.databinding.TaskListFragmentBinding
import com.pavelwinter.myorganizer.presentation.adapters.TasksAdapter
import com.pavelwinter.myorganizer.presentation.view_models.TaskListViewModel

class TaskListFragment : Fragment() {

    private lateinit var viewModel: TaskListViewModel
    lateinit var binding : TaskListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = TaskListFragmentBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TaskListViewModel::class.java)

        setupAdapter(DataTypesGenerator.generateParentList())
    }




    fun setupAdapter(itemsList : List<ParentType>){
        with(binding.taskListFragmentRv){
            adapter = TasksAdapter(itemsList)
            layoutManager = LinearLayoutManager(this@TaskListFragment.activity)
        }
    }

}
