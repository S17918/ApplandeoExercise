package com.applandeo.excercise.ui.presentation.mission_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.applandeo.excercise.models.Mission

class MissionDetailsViewModel : ViewModel() {

    private var mission: MutableLiveData<Mission> = MutableLiveData()

    fun setMission(mission: Mission){
        this.mission.value = mission
    }

    fun getMission(): LiveData<Mission> {
        return mission
    }

}