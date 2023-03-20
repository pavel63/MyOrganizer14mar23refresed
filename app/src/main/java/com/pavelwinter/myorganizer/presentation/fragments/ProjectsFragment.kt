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
import com.pavelwinter.myorganizer.databinding.ProjectsFragmentBinding
import com.pavelwinter.myorganizer.presentation.adapters.ProjectsAdapter
import com.pavelwinter.myorganizer.presentation.view_models.ProjectsViewModel

class ProjectsFragment : Fragment() {
lateinit var binding : ProjectsFragmentBinding
    companion object {
        fun newInstance() = ProjectsFragment()
    }

    private lateinit var viewModel: ProjectsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProjectsFragmentBinding.inflate(LayoutInflater.from(context),container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ProjectsViewModel::class.java)
        setupAdapter(DataTypesGenerator.generateParentList())
    }


    private fun setupAdapter(projectsFragment: List<ParentType>) {
        with(binding.projectsFragmentRv) {
            adapter = ProjectsAdapter(projectsFragment)
            layoutManager = LinearLayoutManager(this@ProjectsFragment.activity)
        }
    }

}
