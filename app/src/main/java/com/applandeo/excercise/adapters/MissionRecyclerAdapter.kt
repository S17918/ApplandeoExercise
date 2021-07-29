package com.applandeo.excercise.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.applandeo.excercise.R
import com.applandeo.excercise.models.Mission
import com.applandeo.excercise.util.OnMissionListener

class MissionRecyclerAdapter(private val clickListener: OnMissionListener) : RecyclerView.Adapter<MissionRecyclerAdapter.ViewHolder>() {

    private var missionList: List<Mission> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_mission, parent, false), clickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(missionList[position])
    }

    override fun getItemCount(): Int {
        if(missionList.isNotEmpty()){
            return missionList.size
        }
        return 0
    }

    fun setMissions(list: List<Mission>){
        missionList = list
        notifyDataSetChanged()
    }

    class ViewHolder(itemView : View, val clickListener: OnMissionListener) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private var missionName: TextView? = null
        private var missionId: TextView? = null

        init{
            missionName = itemView.findViewById(R.id.mission_name)
            missionId = itemView.findViewById(R.id.mission_id)
            itemView.setOnClickListener(this)
        }

        fun bind(mission: Mission){
            missionName?.text = mission.mission_name
            missionId?.text = "ID: " + mission.mission_id
        }

        override fun onClick(v: View?) {
            clickListener.onMissionClick(adapterPosition)
        }
    }
}