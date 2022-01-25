package com.pos.lms.mobile.ui.student.detailStudent.insight

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pos.lms.core.domain.model.InsightList
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ItemListInsightBinding
import com.pos.lms.mobile.helper.Debounce.onThrottledClick
import com.pos.lms.mobile.helper.TimeAgo
import com.pos.lms.mobile.helper.loadImage

class InsightAdapter : RecyclerView.Adapter<InsightAdapter.UserViewHolder>() {

    var onLikeClick: ((InsightList) -> Unit)? = null

    var onDeleteClick: ((InsightList) -> Unit)? = null

    var onUpdateClick: ((InsightList) -> Unit)? = null

    private var mOwner: String = ""
    private val mData = ArrayList<InsightList>()

    fun setData(newListData: List<InsightList>?, username: String?) {
        if (newListData == null) return
        mData.clear()
        mData.addAll(newListData)
        this.mOwner = username.toString()
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

            val convTime = TimeAgo.covertTimeToText(data.changeDate)

            binding.tvTittle.text = data.forumTitle
            binding.tvDescription.text = data.forumText
            binding.tvDate.text = convTime

            if (data.owner != mOwner) {
                binding.ivDelete.visibility = View.GONE
                binding.ivUpdate.visibility = View.GONE
            }

//            Glide.with(itemView.context)
//                .load(data.forumImage)
//                .error(R.drawable.banner_home)
//                .into(binding.ivInsight)
            binding.ivInsight.loadImage(itemView.context, data.forumImage)
//            binding.tvId.text = data.owner
        }

        init {
            binding.imageView6.onThrottledClick {
                onLikeClick?.invoke(mData[adapterPosition])
            }
            binding.ivDelete.onThrottledClick {
                onDeleteClick?.invoke(mData[adapterPosition])
            }
            binding.ivUpdate.onThrottledClick {
                onUpdateClick?.invoke(mData[adapterPosition])
            }
        }

    }

}