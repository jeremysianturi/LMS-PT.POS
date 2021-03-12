package com.pos.lms.mobile.ui.student.detailStudent.session.detail.schedule.detailSchedule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pos.lms.core.domain.model.QuisionerSchedule
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ItemListRoomBinding

/**
 * Created by Muhammad Zaim Milzam on 15/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
class QuisionerAdapter : RecyclerView.Adapter<QuisionerAdapter.UserViewHolder>() {

    var onItemClick: ((QuisionerSchedule) -> Unit)? = null

    private val mData = ArrayList<QuisionerSchedule>()

    fun setData(newListData: List<QuisionerSchedule>?) {
        if (newListData == null) return
        mData.clear()
        mData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): QuisionerAdapter.UserViewHolder {
        val mView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_room, parent, false)
        return UserViewHolder(mView)
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: QuisionerAdapter.UserViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListRoomBinding.bind(itemView)
        fun bind(data: QuisionerSchedule) {

            binding.tvMeetingRoom.text = data.templateCodeName
            binding.tvBuilding.text =
                if (data.templateTypeName == "") data.templateTypeId else data.templateTypeName
            binding.tvFloor.text = "Start Quisioner"

//            if (data.score == "" || data.score == null) {
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