package com.pos.lms.mobile.ui.student.detailStudent.session

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pos.lms.core.domain.model.SessionList
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ItemListSessionBinding


class SessionAdapter : RecyclerView.Adapter<SessionAdapter.UserViewHolder>() {

    var onItemClick: ((SessionList) -> Unit)? = null

    private val mData = ArrayList<SessionList>()

    fun setData(newListData: List<SessionList>?) {
        if (newListData == null) return
        mData.clear()
        mData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SessionAdapter.UserViewHolder {
        val mView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_session, parent, false)
        return UserViewHolder(mView)
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: SessionAdapter.UserViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListSessionBinding.bind(itemView)
        fun bind(data: SessionList) {
            // concat string
            binding.tvTitleItem.text = data.sessionName
            binding.tvContent.text = data.activityName
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(mData[adapterPosition])
            }
        }

    }

}