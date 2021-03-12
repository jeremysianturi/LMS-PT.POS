package com.pos.lms.mobile.ui.student.detailStudent.session.detail.schedule.detailSchedule.detailQuisioner

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pos.lms.core.domain.model.TrainerSchedule
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ItemListRoomBinding

/**
 * Created by Muhammad Zaim Milzam on 15/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
class QuisionerAdapter : RecyclerView.Adapter<QuisionerAdapter.UserViewHolder>() {

    var onItemClick: ((TrainerSchedule) -> Unit)? = null

    private val mData = ArrayList<TrainerSchedule>()

    fun setData(newListData: List<TrainerSchedule>?) {
        if (newListData == null) return
        mData.clear()
        mData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserViewHolder {
        val mView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_room, parent, false)
        return UserViewHolder(mView)
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListRoomBinding.bind(itemView)
        fun bind(data: TrainerSchedule) {

            var status = ""

            when (data.relation) {
                "ST02" -> {
                    status = "Approved"
                    binding.tvBuilding.setTextColor(Color.GREEN)
                }
                "ST01" -> {
                    status = "Not approved yet"
                    binding.tvBuilding.setTextColor(Color.YELLOW)

                }
                else -> {
                    status = " Disapproved"
                    binding.tvBuilding.setTextColor(Color.RED)
                }
            }

            binding.tvMeetingRoom.text = data.trainerName
            binding.tvBuilding.text = status
            binding.tvFloor.text = data.companyName
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(mData[adapterPosition])
            }
        }

    }

}