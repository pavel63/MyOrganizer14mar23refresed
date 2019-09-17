package com.pavelwinter.myorganizer.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pavelwinter.myorganizer.R
import com.pavelwinter.myorganizer.data.db.db_entities.ParentType
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.row_project_item.view.*

class ProjectsAdapter(var projectsList : List<ParentType>):RecyclerView.Adapter<ProjectsAdapter.ProjectsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_project_item,parent,false)
        return ProjectsViewHolder(view)
    }


    override fun getItemCount() = projectsList .size


    override fun onBindViewHolder(holder: ProjectsViewHolder, position: Int) {
        holder.bind(projectsList[position])
    }


    inner class ProjectsViewHolder(view : View): RecyclerView.ViewHolder(view), LayoutContainer{
        override val containerView: View?
            get() = itemView

        fun bind(model : ParentType){
           itemView. row_project_item_title_tv .text = model.title
        }

    }
}