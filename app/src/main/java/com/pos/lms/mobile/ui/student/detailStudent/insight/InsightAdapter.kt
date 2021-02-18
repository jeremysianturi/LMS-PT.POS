package com.pos.lms.mobile.ui.student.detailStudent.insight

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pos.lms.core.domain.model.InsightList
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ItemListInsightBinding


class InsightAdapter : RecyclerView.Adapter<InsightAdapter.UserViewHolder>() {

    var onLikeClick: ((InsightList) -> Unit)? = null

    var onDeleteClick: ((InsightList) -> Unit)? = null

    var onUpdateClick: ((InsightList) -> Unit)? = null

    private val mData = ArrayList<InsightList>()

    fun setData(newListData: List<InsightList>?) {
        if (newListData == null) return
        mData.clear()
        mData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): InsightAdapter.UserViewHolder {
        val mView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_insight, parent, false)
        return UserViewHolder(mView)
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: InsightAdapter.UserViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListInsightBinding.bind(itemView)
        fun bind(data: InsightList) {

            // concat string
//            binding.tvTitleItem.text = data.sessionName
//            binding.tvContent.text = data.activityName
            binding.tvTittle.text = data.forumTitle
            binding.tvDescription.text = data.forumText
            binding.tvDate.text = data.forumTime

            Glide.with(itemView.context)
                .load(data.forumImage)
                .error(R.drawable.banner_home)
                .into(binding.ivInsight)
//            binding.tvId.text = data.owner
        }

        init {
            binding.imageView6.setOnClickListener {
                onLikeClick?.invoke(mData[adapterPosition])
            }
            binding.ivDelete.setOnClickListener {
                onDeleteClick?.invoke(mData[adapterPosition])
            }
            binding.ivUpdate.setOnClickListener {
                onUpdateClick?.invoke(mData[adapterPosition])
            }
        }

    }

}