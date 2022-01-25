package com.pos.lms.mobile.ui.student.detailStudent.session.detail.schedule.detailSchedule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pos.lms.core.domain.model.MateriSchedule
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ItemListMateriBinding

class MateriAdapter : RecyclerView.Adapter<MateriAdapter.UserViewHolder>() {

    var onItemClick: ((MateriSchedule) -> Unit)? = null

    private val mData = ArrayList<MateriSchedule>()

    fun setData(newListData: List<MateriSchedule>?) {
        if (newListData == null) return
        mData.clear()
        mData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MateriAdapter.UserViewHolder {
        val mView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_materi, parent, false)
        return UserViewHolder(mView)
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: MateriAdapter.UserViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListMateriBinding.bind(itemView)
        fun bind(data: MateriSchedule) {

            // concat string
            val contentProposal = "${data.companyName} - ${data.materiTypeName}"

            binding.tvTitleListProposal.text = data.materiName
            binding.tvContentProposal.text = contentProposal
            binding.tvDetailContentProposal.text = data.competenceName
            binding.tvLevelProposal.text = data.plCodeName
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(mData[adapterPosition])
            }
        }

    }

}