package com.pos.lms.mobile.ui.roadmap.scp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pos.lms.core.domain.model.SCPRotasi
import com.pos.lms.mobile.R
import com.pos.lms.mobile.databinding.ItemListEcpBinding

class SCPRotasiAdapter : RecyclerView.Adapter<SCPRotasiAdapter.UserViewHolder>() {

    var onItemClick: ((SCPRotasi) -> Unit)? = null

    private val mData = ArrayList<SCPRotasi>()

    fun setData(newListData: List<SCPRotasi>?) {
        if (newListData == null) return
        mData.clear()
        mData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SCPRotasiAdapter.UserViewHolder {
        val mView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_ecp, parent, false)
        return UserViewHolder(mView)
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: SCPRotasiAdapter.UserViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListEcpBinding.bind(itemView)
        fun bind(data: SCPRotasi) {
            with(binding) {

                // concat data
                val applicants =
                    if (data.applicants == "null" || data.applicants == "") "-" else data.applicants
                val jobLevel =
                    if (data.levelJabatan == "null" || data.levelJabatan == "") "-" else data.levelJabatan
                val ranking =
                    if (data.ranking == "null" || data.ranking == "") "-" else data.ranking
                val score = if (data.score == "null" || data.score == "") "-" else data.score


                tvJobName.text = data.jobName
                tvPossition.text = data.positionName
                tvKantor.text = data.kantorName

                tvContentApplicants.text = applicants
                tvContentJobLevel.text = jobLevel
                tvContentRank.text = ranking
                tvContentScore.text = score
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(mData[adapterPosition])
            }
        }


    }

}