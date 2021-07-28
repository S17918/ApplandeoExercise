package com.applandeo.excercise.ui.presentation.mission_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.applandeo.excercise.models.Mission
import com.applandeo.excercise.repositories.MissionRepository

class MissionListViewModel : ViewModel() {

    private val repository: MissionRepository = MissionRepository()

    fun getMissions(): LiveData<List<Mission>>{
        return repository.getMissions()
    }

    fun callApi(){
        repository.callApi()
    }
}