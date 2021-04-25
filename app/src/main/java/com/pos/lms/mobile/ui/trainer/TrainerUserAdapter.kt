package com.pos.lms.mobile.ui.trainer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pos.lms.core.domain.model.TrainerUser
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ItemListTrainerBinding

/**
 * Created by Muhammad Zaim Milzam on 15/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
class TrainerUserAdapter : RecyclerView.Adapter<TrainerUserAdapter.UserViewHolder>() {

    var onItemClick: ((TrainerUser) -> Unit)? = null

    private val mData = ArrayList<TrainerUser>()

    fun setData(newListData: List<TrainerUser>?) {
        if (newListData == null) return
        mData.clear()
        mData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrainerUserAdapter.UserViewHolder {
        val mView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_trainer, parent, false)
        return UserViewHolder(mView)
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: TrainerUserAdapter.UserViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListTrainerBinding.bind(itemView)
        fun bind(data: TrainerUser) {
            binding.apply {
                tvContentDayNum.text = data.dayNumber.toString()
                tvContentSceduleDate.text = data.bEGDA
                tvContentTime.text = "${data.beginTime} - ${data.endTime}"
                tvContentTopic.text = data.topic
                tvContentTittle.text = data.scheduleName
                tvContentEvent.text = data.eventName
                tvContentBatch.text = data.batchName
                tvContentSession.text = data.sessionName

            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(mData[adapterPosition])
            }
        }

    }

}