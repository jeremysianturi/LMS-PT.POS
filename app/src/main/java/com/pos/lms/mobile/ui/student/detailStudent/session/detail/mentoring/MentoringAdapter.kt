package com.pos.lms.mobile.ui.student.detailStudent.session.detail.mentoring

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pos.lms.core.domain.model.Mentoring
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ItemListMentoringBinding
import com.pos.lms.mobile.helper.DateTimeConverter
/**
 * Created by Muhammad Zaim Milzam on 15/02/21.
 * linkedin : Muhammad Zaim Milzam
 */

class MentoringAdapter : RecyclerView.Adapter<MentoringAdapter.UserViewHolder>() {

    var onItemClick: ((Mentoring) -> Unit)? = null

    private val mData = ArrayList<Mentoring>()

    fun setData(newListData: List<Mentoring>?) {
        if (newListData == null) return
        mData.clear()
        mData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MentoringAdapter.UserViewHolder {
        val mView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_mentoring, parent, false)
        return UserViewHolder(mView)
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: MentoringAdapter.UserViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListMentoringBinding.bind(itemView)
        fun bind(data: Mentoring) {
            val dateStart = DateTimeConverter.dateConverter(data.beginDate)
            val dateEnd = DateTimeConverter.dateConverter(data.endDate)
            val date = "$dateStart - $dateEnd"
            val topic = "Topic : ${data.topic}"

            binding.tvContentDuration.text = data.duration
            binding.tvTitle.text = data.title
            binding.tvTopic.text = topic
            binding.tvContentdesc.text = data.description
            binding.tvDate.text = date

        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(mData[adapterPosition])
            }
        }

    }

}