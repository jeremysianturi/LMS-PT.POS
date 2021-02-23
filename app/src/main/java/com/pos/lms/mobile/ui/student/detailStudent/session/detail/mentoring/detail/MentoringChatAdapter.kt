package com.pos.lms.mobile.ui.student.detailStudent.session.detail.mentoring.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pos.lms.core.domain.model.MentoringChat
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ItemListChatLeftBinding


class MentoringChatAdapter : RecyclerView.Adapter<MentoringChatAdapter.UserViewHolder>() {

    var onItemClick: ((MentoringChat) -> Unit)? = null

    private val mData = ArrayList<MentoringChat>()

    fun setData(newListData: List<MentoringChat>?) {
        if (newListData == null) return
        mData.clear()
        mData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MentoringChatAdapter.UserViewHolder {
        val mView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_chat_left, parent, false)
        return UserViewHolder(mView)
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: MentoringChatAdapter.UserViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListChatLeftBinding.bind(itemView)
        fun bind(data: MentoringChat) {

            binding.tvChat.text = data.chatText
            binding.tvSender.text = data.senderName
            binding.tvDate.text = data.beginDate

        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(mData[adapterPosition])
            }
        }

    }

}