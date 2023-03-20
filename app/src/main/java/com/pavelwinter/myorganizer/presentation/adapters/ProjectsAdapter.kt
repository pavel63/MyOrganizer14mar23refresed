package com.pavelwinter.myorganizer.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pavelwinter.myorganizer.data.db.db_entities.ParentType
import com.pavelwinter.myorganizer.databinding.RowProjectItemBinding

class ProjectsAdapter(var projectsList : List<ParentType>):RecyclerView.Adapter<ProjectsAdapter.ProjectsViewHolder>() {

    lateinit var binding : RowProjectItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectsViewHolder {

        binding = RowProjectItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProjectsViewHolder(binding)
    }

    override fun getItemCount() = projectsList .size


    override fun onBindViewHolder(holder: ProjectsViewHolder, position: Int) {
        holder.bind(projectsList[position])
    }


    inner class ProjectsViewHolder(binding: RowProjectItemBinding): RecyclerView.ViewHolder(binding.root){
        val containerView: View
            get() = itemView

        fun bind(model : ParentType){
          binding.rowProjectItemTitleTv.text = model.title
        }

    }
}