package com.pos.lms.mobile.ui.mentor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pos.lms.core.domain.model.MentorUser
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ItemListMentorBinding

/**
 * Created by Muhammad Zaim Milzam on 15/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
class MentorAdapter : RecyclerView.Adapter<MentorAdapter.UserViewHolder>() {

    var onItemClick: ((MentorUser) -> Unit)? = null

    private val mData = ArrayList<MentorUser>()

    fun setData(newListData: List<MentorUser>?) {
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
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_mentor, parent, false)
        return UserViewHolder(mView)
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: MentorAdapter.UserViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListMentorBinding.bind(itemView)
        fun bind(data: MentorUser) {
            with(binding) {

                tvContentTopic.text = data.mentoringTopic
                tvContentTitle.text = data.mentoringTitle
                tvContentDuration.text = data.mentoringDuration.toString()
                tvContentDescription.text = data.mentoringDescription
                tvContentDate.text = "${data.beginDate} - ${data.endDate}"
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(mData[adapterPosition])
            }
        }


    }

}