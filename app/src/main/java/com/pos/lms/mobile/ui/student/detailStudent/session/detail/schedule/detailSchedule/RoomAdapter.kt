package com.pos.lms.mobile.ui.student.detailStudent.session.detail.schedule.detailSchedule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pos.lms.core.domain.model.RoomSchedule
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ItemListRoomBinding

class RoomAdapter : RecyclerView.Adapter<RoomAdapter.UserViewHolder>() {

    var onItemClick: ((RoomSchedule) -> Unit)? = null

    private val mData = ArrayList<RoomSchedule>()

    fun setData(newListData: List<RoomSchedule>?) {
        if (newListData == null) return
        mData.clear()
        mData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RoomAdapter.UserViewHolder {
        val mView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_room, parent, false)
        return UserViewHolder(mView)
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: RoomAdapter.UserViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListRoomBinding.bind(itemView)
        fun bind(data: RoomSchedule) {

            val floor = "Lantai ${data.floorName}"

            binding.tvBuilding.text = data.buildingName
            binding.tvMeetingRoom.text = data.roomName
            binding.tvFloor.text = floor
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(mData[adapterPosition])
            }
        }

    }

}