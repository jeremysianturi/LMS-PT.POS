package com.pos.lms.mobile.ui.student.detailStudent.session.detail.schedule.detailSchedule.detailQuisioner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pos.lms.core.domain.model.QuisionerAnswer
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ItemListAnswerBinding


class AnswerAdapter : RecyclerView.Adapter<AnswerAdapter.UserViewHolder>() {

    var onItemClick: ((QuisionerAnswer) -> Unit)? = null

    private val mData = ArrayList<QuisionerAnswer>()

    fun setData(newListData: List<QuisionerAnswer>?) {
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
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_answer, parent, false)
        return UserViewHolder(mView)
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListAnswerBinding.bind(itemView)
        fun bind(data: QuisionerAnswer) {

            val checked = "${data.textChoice} = checked"
            binding.tvAnswer.text = data.textChoice

            when (data.isChecked) {
                false -> binding.tvAnswer.text = data.textChoice
                true -> binding.tvAnswer.text = checked
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(mData[adapterPosition])
            }
        }

    }

}