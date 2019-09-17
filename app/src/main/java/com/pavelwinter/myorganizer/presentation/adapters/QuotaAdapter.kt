package com.pavelwinter.myorganizer.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.pavelwinter.myorganizer.R
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.pavelwinter.myorganizer.data.db.db_entities.ParentType
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.row_quota.view.*


class QuotaAdapter(var quotaList: List<ParentType>) :
    RecyclerView.Adapter<QuotaAdapter.QuotaViewHolder>() {

    override fun getItemCount() = quotaList.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_quota, parent, false)
        return QuotaViewHolder(view)
    }



    override fun onBindViewHolder(holder: QuotaViewHolder, position: Int) {
        holder.bind(quotaList[position])
    }



    inner class QuotaViewHolder(view: View) : RecyclerView.ViewHolder(view), LayoutContainer {
        override val containerView: View?
            get() = itemView

        fun bind(model: ParentType) {

            with(model) {
                itemView.row_quota_name_tv.text = model.title
                itemView.row_quota_repeats_tv.text = model.describing
                itemView.row_quota_done_tv .text = model.percentDone.toString()
                //itemView.row_quota_rest_tv .text = model.percentDone.toString()
               // itemView.row_quota_percent_string_tv.background = model.percentDone
            }
        }

    }

}


