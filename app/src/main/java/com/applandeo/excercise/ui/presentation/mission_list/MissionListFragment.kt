package com.applandeo.excercise.ui.presentation.mission_list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.applandeo.excercise.R
import com.applandeo.excercise.models.Mission
import com.applandeo.excercise.requests.Client
import com.applandeo.excercise.requests.Service
import com.applandeo.excercise.requests.responses.MissionResponse
import io.reactivex.rxjava3.schedulers.Schedulers

class MissionListFragment : Fragment() {

    private lateinit var viewModel: MissionListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.mission_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MissionListViewModel::class.java)

        subscribeObservers()

        val button: Button? = view?.findViewById(R.id.button)
        button?.setOnClickListener{
            viewModel.callApi()
        }

    }

    private fun subscribeObservers(){
        viewModel.getMissions().observe(viewLifecycleOwner) {
            for(mission: Mission in it){
                println(mission.mission_id)
            }
        }
    }
}