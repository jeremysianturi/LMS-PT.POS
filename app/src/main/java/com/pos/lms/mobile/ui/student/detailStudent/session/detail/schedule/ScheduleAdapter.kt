package com.pos.lms.mobile.ui.student.detailStudent.session.detail.schedule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pos.lms.core.domain.model.Schedule
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ItemListScheduleBinding
import com.pos.lms.mobile.helper.DateTimeConverter


class ScheduleAdapter : RecyclerView.Adapter<ScheduleAdapter.UserViewHolder>() {

    var onItemClick: ((Schedule) -> Unit)? = null

    private val mData = ArrayList<Schedule>()

    fun setData(newListData: List<Schedule>?) {
        if (newListData == null) return
        mData.clear()
        mData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ScheduleAdapter.UserViewHolder {
        val mView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_schedule, parent, false)
        return UserViewHolder(mView)
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: ScheduleAdapter.UserViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListScheduleBinding.bind(itemView)
        fun bind(data: Schedule) {

            // concat string
            val startTime = data.beginTime?.let { DateTimeConverter.toHourMinutes(it) }
            val endTime = data.endTime?.let { DateTimeConverter.toHourMinutes(it) }
            val time = "$startTime - $endTime"
            data.dayNumber.toString().also { binding.tvContentDayNum.text = it }
            data.scheduleName.also { binding.tvTitle.text = it }
            data.topic.also { binding.tvContentdesc.text = it }
            data.scheduleDate?.let { DateTimeConverter.dateWithDayConverter(it) }
                .also { binding.tvDate.text = it }
            time.also { binding.tvTime.text = it }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(mData[adapterPosition])
            }
        }

    }

}