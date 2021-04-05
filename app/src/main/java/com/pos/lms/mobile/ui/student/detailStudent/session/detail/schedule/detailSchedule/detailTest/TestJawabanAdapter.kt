package com.pos.lms.mobile.ui.student.detailStudent.session.detail.schedule.detailSchedule.detailTest

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pos.lms.core.domain.model.TestJawaban
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ItemListAnswerBinding

/**
 * Created by Muhammad Zaim Milzam on 15/02/21.
 * linkedin : Muhammad Zaim Milzam
 */
class TestJawabanAdapter : RecyclerView.Adapter<TestJawabanAdapter.UserViewHolder>() {

    var onItemClick: ((TestJawaban) -> Unit)? = null

    private val mData = ArrayList<TestJawaban>()
    private var mChecked = 0

    fun setData(newListData: List<TestJawaban>?) {
        if (newListData == null) return
        mData.clear()
        mData.addAll(newListData)
        notifyDataSetChanged()
    }

    fun setChecked(objectIdentifier: Int) {
        mChecked = objectIdentifier
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
        holder.bind(mData[position], mChecked)
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListAnswerBinding.bind(itemView)
        fun bind(data: TestJawaban, checkedId: Int) {

            val checked = "${data.textChoice} = checked"
            binding.tvAnswer.text = data.textChoice

            if (data.objectIdentifier == checkedId) {
                binding.tvAnswer.setBackgroundColor(Color.GREEN)
            } else {
                binding.tvAnswer.setBackgroundColor(Color.WHITE)
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(mData[adapterPosition])
            }
        }

    }

}

