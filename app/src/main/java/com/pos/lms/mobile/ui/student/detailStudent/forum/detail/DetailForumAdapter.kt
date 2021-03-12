package com.pos.lms.mobile.ui.student.detailStudent.forum.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pos.lms.core.domain.model.ForumComment
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ItemListCommentBinding

/**
 * Created by Muhammad Zaim Milzam on 15/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
class DetailForumAdapter : RecyclerView.Adapter<DetailForumAdapter.UserViewHolder>() {

    var onItemClick: ((ForumComment) -> Unit)? = null

    private val mData = ArrayList<ForumComment>()

    fun setData(newListData: List<ForumComment>?) {
        if (newListData == null) return
        mData.clear()
        mData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DetailForumAdapter.UserViewHolder {
        val mView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_comment, parent, false)
        return UserViewHolder(mView)
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: DetailForumAdapter.UserViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListCommentBinding.bind(itemView)
        fun bind(data: ForumComment) {
            // concat string

            binding.tvTittle.text = data.owner
            binding.tvContent.text = data.comment
            binding.tvDateTime.text = data.beginDate
            binding.tvLike.text = "0 (hardcode)"

        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(mData[adapterPosition])
            }
        }

    }

}