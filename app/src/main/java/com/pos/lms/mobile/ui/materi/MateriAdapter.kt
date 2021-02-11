package com.pos.lms.mobile.ui.materi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pos.lms.core.domain.model.Materi
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ItemListProposalBinding


class MateriAdapter : RecyclerView.Adapter<MateriAdapter.UserViewHolder>() {

    var onItemClick: ((Materi) -> Unit)? = null

    private val mData = ArrayList<Materi>()

    fun setData(newListData: List<Materi>?) {
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
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_proposal, parent, false)
        return UserViewHolder(mView)
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: MateriAdapter.UserViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListProposalBinding.bind(itemView)
        fun bind(data: Materi) {
            with(binding) {

                // concat string
                val contentProposal = "${data.companyName} - ${data.materiTypeName}"

                tvTitleListProposal.text = data.materiName
                tvContentProposal.text = contentProposal
                tvDetailContentProposal.text = data.competenceName
                tvLevelProposal.text = data.plCodeName
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(mData[adapterPosition])
            }
        }


    }

}