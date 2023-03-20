package com.pavelwinter.myorganizer.presentation.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pavelwinter.myorganizer.data.db.db_entities.ParentType
import com.pavelwinter.myorganizer.databinding.RowTasksBinding
import com.pavelwinter.myorganizer.presentation.utils.PriorityInterface


class TasksAdapter(var tasksList: List<ParentType>) :
    RecyclerView.Adapter<TasksAdapter.TasksViewHolder>() {

    lateinit var binding :RowTasksBinding

    override fun getItemCount() = tasksList.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {

        binding = RowTasksBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return TasksViewHolder(binding)
    }


    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        holder.bind(tasksList[position])
    }

    inner class TasksViewHolder(binding: RowTasksBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(model: ParentType) {

            when(model.priority){
                 PriorityInterface.HIGH_PRIORITY.ordinal->{
                     //нужно будет сделать потом
                   //  itemView .row_project_item_title_tv.setBackgroundColor(Color.RED)
                 }
                 PriorityInterface.MIDDLE_PRIORITY.ordinal->{
                     binding.rowTasksIndicatorV.setBackgroundColor(Color.YELLOW)
                 }
                 PriorityInterface.LOW_PRIORITY.ordinal->{
                     binding.rowTasksIndicatorV.setBackgroundColor(Color.GREEN)
                 }
             }

             binding.rowTasksNameTv .text = model.title
             binding.rowTasksRestTv .text = model.percentDone.toString()
        }

    }

}
