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
    private lateinit var missionName: TextView
    private lateinit var missionId: TextView
    private lateinit var missionManufacturers: TextView
    private lateinit var missionPayloads: TextView
    private lateinit var missionDescription: TextView
    private lateinit var missionWebsite: TextView
    private lateinit var missionTwitter: TextView
    private lateinit var missionWikipedia: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.mission_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MissionDetailsViewModel::class.java)
        val mission: Mission = arguments?.getParcelable<Mission>("mission")!!
        viewModel.setMission(mission)
        initTextViews()

    }

    private fun initTextViews(){

        missionName = view?.findViewById(R.id.details_mission_name)!!
        missionId = view?.findViewById(R.id.details_mission_id)!!
        missionManufacturers = view?.findViewById(R.id.details_manufacturers)!!
        missionPayloads = view?.findViewById(R.id.details_payload_ids)!!
        missionDescription = view?.findViewById(R.id.details_description)!!
        missionWebsite = view?.findViewById(R.id.details_website)!!
        missionTwitter = view?.findViewById(R.id.details_twitter)!!
        missionWikipedia = view?.findViewById(R.id.details_wikipedia)!!

        viewModel.getMission().observe(viewLifecycleOwner) {
            missionName?.text = it.mission_name
            missionId?.text = "ID: " + it.mission_id
            missionManufacturers?.text = it.manufacturers.toString().replace("[", "").replace("]", "").replace(", ", "\n")
            missionPayloads?.text = it.payload_ids.toString().replace("[", "").replace("]", "").replace(", ", "\n")
            missionDescription?.text = it.description
            missionWebsite?.text = it.website
            missionTwitter?.text = it.twitter
            missionWikipedia?.text = it.wikipedia
        }
    }

}