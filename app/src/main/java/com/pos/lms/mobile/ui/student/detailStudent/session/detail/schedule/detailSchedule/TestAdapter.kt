package com.pos.lms.mobile.ui.student.detailStudent.session.detail.schedule.detailSchedule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pos.lms.core.domain.model.TestSchedule
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ItemListRoomBinding


class TestAdapter : RecyclerView.Adapter<TestAdapter.UserViewHolder>() {

    var onItemClick: ((TestSchedule) -> Unit)? = null

    private val mData = ArrayList<TestSchedule>()

    fun setData(newListData: List<TestSchedule>?) {
        if (newListData == null) return
        mData.clear()
        mData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TestAdapter.UserViewHolder {
        val mView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_room, parent, false)
        return UserViewHolder(mView)
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: TestAdapter.UserViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListRoomBinding.bind(itemView)
        fun bind(data: TestSchedule) {

            binding.tvMeetingRoom.text = data.testCodeName
            binding.tvBuilding.text = data.testTypeName
            binding.tvFloor.text = "0(harcode)"

//            if (data.sc == "" || data.score == null) {
//                tvFloor.visibility = View.GONE
//            } else {
//                tvFloor.text = data.score
//
//            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(mData[adapterPosition])
            }
        }

    }

}