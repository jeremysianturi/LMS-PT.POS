package com.pos.lms.mobile.ui.student

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pos.lms.core.domain.model.Student
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ItemListStudentBinding


class StudentAdapter : RecyclerView.Adapter<StudentAdapter.UserViewHolder>() {

    var onItemClick: ((Student) -> Unit)? = null

    private val mData = ArrayList<Student>()

    fun setData(newListData: List<Student>?) {
        if (newListData == null) return
        mData.clear()
        mData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StudentAdapter.UserViewHolder {
        val mView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_student, parent, false)
        return UserViewHolder(mView)
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: StudentAdapter.UserViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListStudentBinding.bind(itemView)
        fun bind(data: Student) {
            // concat string
            val content1 = "${data.companyName} - ${data.batchName} - ${data.location}"
            val content2 = "${data.eventType} - ${data.curriculum}"
            val date = "${data.beginDate} - ${data.endDate}"

            binding.tvTitle.text = data.eventName
            binding.tvContentStudentList.text = content1
            binding.tvDetailContentStudent.text = content2
            binding.tvDate.text = date
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(mData[adapterPosition])
            }
        }

    }

}