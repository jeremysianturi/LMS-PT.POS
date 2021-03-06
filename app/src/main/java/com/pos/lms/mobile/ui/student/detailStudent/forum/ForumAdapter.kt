package com.pos.lms.mobile.ui.student.detailStudent.forum

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pos.lms.core.domain.model.ForumList
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ItemListForumBinding
import com.pos.lms.mobile.helper.TimeAgo
import com.pos.lms.mobile.helper.loadImage

class ForumAdapter : RecyclerView.Adapter<ForumAdapter.UserViewHolder>() {

    var onItemClick: ((ForumList) -> Unit)? = null
    var onItemUpdateClick: ((ForumList) -> Unit)? = null
    var onItemDeleteClick: ((ForumList) -> Unit)? = null

    private val mData = ArrayList<ForumList>()
    private var mOwner: String = ""

    fun setData(newListData: List<ForumList>?, username: String?) {
        if (newListData == null) return
        mData.clear()
        mData.addAll(newListData)
        this.mOwner = username.toString()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ForumAdapter.UserViewHolder {
        val mView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_forum, parent, false)
        return UserViewHolder(mView)
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: ForumAdapter.UserViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListForumBinding.bind(itemView)
        fun bind(data: ForumList) {

            // concat string

//            binding.tvTitleItem.text = data.sessionName
//            binding.tvContent.text = data.activityName
            // convertTimeAgo
            val convTime = TimeAgo.covertTimeToText(data.changeDate)

            binding.tvTittle.text = data.forumTitle
            binding.tvBatch.text = data.batchName
            binding.tvDate.text = convTime
            binding.tvId.text = data.owner

            if (data.owner != mOwner) {
                binding.ivDelete.visibility = View.GONE
                binding.ivUpdate.visibility = View.GONE
            }

//            Glide.with(itemView.context)
//                .load(data.forumImage)
//                .error(R.drawable.banner_home)
//                .into(binding.imageView2)
            binding.imageView2.loadImage(itemView.context,data.forumImage)
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(mData[adapterPosition])
            }
            binding.ivUpdate.setOnClickListener {
                onItemUpdateClick?.invoke(mData[adapterPosition])
            }
            binding.ivDelete.setOnClickListener {
                onItemDeleteClick?.invoke(mData[adapterPosition])
            }
        }

    }

}