package com.pos.lms.mobile.ui.mentor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pos.lms.core.domain.model.Curiculum
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ItemListProposalBinding

/**
 * Created by Muhammad Zaim Milzam on 15/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
class MentorAdapter : RecyclerView.Adapter<MentorAdapter.UserViewHolder>() {

    var onItemClick: ((Curiculum) -> Unit)? = null

    private val mData = ArrayList<Curiculum>()

    fun setData(newListData: List<Curiculum>?) {
        if (newListData == null) return
        mData.clear()
        mData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MentorAdapter.UserViewHolder {
        val mView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_proposal, parent, false)
        return UserViewHolder(mView)
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: MentorAdapter.UserViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListProposalBinding.bind(itemView)
        fun bind(data: Curiculum) {
            with(binding) {

                // concat string
                val contentProposal = "${data.companyName} - ${data.requestTypeName}"

                tvTitleListProposal.text = data.requestName
                tvContentProposal.text = contentProposal
                tvDetailContentProposal.text = data.competenceName
                tvLevelProposal.text = data.plName
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(mData[adapterPosition])
            }
        }


    }

}