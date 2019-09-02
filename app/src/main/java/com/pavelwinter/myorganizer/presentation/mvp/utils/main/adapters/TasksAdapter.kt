package com.pavelwinter.myorganizer.presentation.mvp.utils.main.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pavelwinter.myorganizer.R
import com.pavelwinter.myorganizer.presentation.mvp.utils.main.utils.PriorityInterface
import com.pavelwinter.myorganizer.presentation.mvp.utils.main.models.TasksModel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.row_tasks.view.*


class TasksAdapter(var tasksList: List<TasksModel>) :
    RecyclerView.Adapter<TasksAdapter.TasksViewHolder>() {

    override fun getItemCount() = tasksList.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_tasks, parent, false)
        return TasksViewHolder(view)
    }



    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        holder.bind(tasksList[position])
    }



    inner class TasksViewHolder(view: View) : RecyclerView.ViewHolder(view), LayoutContainer {
        override val containerView: View?
            get() = itemView

        fun bind(model: TasksModel) {

            with(model) {

               when(model.priority){
                    PriorityInterface.HIGH_PRIORITY->{
                        itemView.row_tasks_indicator_v.setBackgroundColor(Color.RED)
                    }
                    PriorityInterface.MIDDLE_PRIORITY->{
                        itemView.row_tasks_indicator_v.setBackgroundColor(Color.YELLOW)
                    }
                    PriorityInterface.LOW_PRIORITY->{
                        itemView.row_tasks_indicator_v.setBackgroundColor(Color.GREEN)
                    }
                }

                itemView.row_tasks_name_tv.text = model.title
                itemView.row_tasks_percent_tv .text = model.restPercent.toString()
            }
        }

    }

}
