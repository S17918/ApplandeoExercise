package com.applandeo.excercise.ui.presentation.mission_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.applandeo.excercise.R
import com.applandeo.excercise.adapters.MissionRecyclerAdapter
import com.applandeo.excercise.util.OnMissionListener
import com.applandeo.excercise.models.Mission
import org.koin.androidx.viewmodel.ext.android.viewModel

class MissionListFragment : Fragment(), OnMissionListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MissionRecyclerAdapter
    private val viewModel: MissionListViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.mission_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initRecyclerView()
        viewModel.callApi()
        subscribeObservers()

    }

    private fun initRecyclerView(){
        recyclerView = requireView().findViewById(R.id.missions_list)
        adapter = MissionRecyclerAdapter(this)
        recyclerView?.layoutManager = LinearLayoutManager(context)
        recyclerView?.adapter = adapter
    }

    private fun subscribeObservers(){
        viewModel.getMissions().observe(viewLifecycleOwner) {
            adapter.setMissions(it)
        }
    }

    override fun onMissionClick(pos: Int) {
        val mission: Mission = viewModel.getMissions().value!![pos]
        val bundle = Bundle()
        bundle.putParcelable("mission", mission)
        findNavController().navigate(R.id.showMission, bundle)
    }
}