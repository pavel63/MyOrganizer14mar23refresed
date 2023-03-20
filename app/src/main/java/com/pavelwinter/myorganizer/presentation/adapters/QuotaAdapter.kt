package com.pavelwinter.myorganizer.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pavelwinter.myorganizer.data.db.db_entities.ParentType
import com.pavelwinter.myorganizer.databinding.RowQuotaBinding


class QuotaAdapter(var quotaList: List<ParentType>) :
    RecyclerView.Adapter<QuotaAdapter.QuotaViewHolder>() {
lateinit var binding : RowQuotaBinding
    override fun getItemCount() = quotaList.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotaViewHolder {
        binding = RowQuotaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuotaViewHolder(binding)
    }


    override fun onBindViewHolder(holder: QuotaViewHolder, position: Int) {
        holder.bind(quotaList[position])
    }


    inner class QuotaViewHolder(binding: RowQuotaBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(model: ParentType) {

            binding.rowQuotaNameTv.text = model.title
              binding.rowQuotaRepeatsTv.text = model.describing
              binding.rowQuotaDoneTv.text = model.percentDone.toString()
               //itemView.row_quota_rest_tv .text = model.percentDone.toString()
              // itemView.row_quota_percent_string_tv.background = model.percentDone
        }

    }

}


