package com.applandeo.excercise.ui.presentation.mission_details

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.applandeo.excercise.R
import com.applandeo.excercise.models.Mission


class MissionDetailsFragment : Fragment() {

    private lateinit var viewModel: MissionDetailsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.mission_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MissionDetailsViewModel::class.java)

        val mission: Mission = arguments?.getParcelable<Mission>("mission")!!
        initTextViews(mission)

    }

    private fun initTextViews(mission: Mission){
        val missionName: TextView? = view?.findViewById(R.id.details_mission_name)
        val missionId: TextView? = view?.findViewById(R.id.details_mission_id)
        val missionManufacturers: TextView? = view?.findViewById(R.id.details_manufacturers)
        val missionPayloads: TextView? = view?.findViewById(R.id.details_payload_ids)
        val missionDescription: TextView? = view?.findViewById(R.id.details_description)
        val missionWebsite: TextView? = view?.findViewById(R.id.details_website)
        val missionTwitter: TextView? = view?.findViewById(R.id.details_twitter)
        val missionWikipedia: TextView? = view?.findViewById(R.id.details_wikipedia)


        missionName?.text = mission.mission_name
        missionId?.text = "ID: " + mission.mission_id
        missionManufacturers?.text = mission.manufacturers.toString().replace("[", "").replace("]", "").replace(", ", "\n")
        missionPayloads?.text = mission.payload_ids.toString().replace("[", "").replace("]", "").replace(", ", "\n")
        missionDescription?.text = mission.description
        missionWebsite?.text = mission.website
        missionTwitter?.text = mission.twitter
        missionWikipedia?.text = mission.wikipedia
    }

}