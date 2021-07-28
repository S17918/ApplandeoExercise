package com.applandeo.excercise.ui.presentation.mission_list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.applandeo.excercise.R
import com.applandeo.excercise.adapters.MissionRecyclerAdapter
import com.applandeo.excercise.adapters.OnMissionListener
import com.applandeo.excercise.models.Mission

class MissionListFragment : Fragment(), OnMissionListener {

    private lateinit var viewModel: MissionListViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MissionRecyclerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.mission_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MissionListViewModel::class.java)

        initRecyclerView()
        viewModel.callApi()
        subscribeObservers()

    }

    fun initRecyclerView(){
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

    }
}