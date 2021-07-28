package com.applandeo.excercise.ui.presentation.mission_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.applandeo.excercise.models.Mission
import com.applandeo.excercise.repositories.MissionRepository
import com.applandeo.excercise.repositories.MissionRepositoryImpl

class MissionListViewModel(private val repository: MissionRepository) : ViewModel() {

    fun getMissions(): LiveData<List<Mission>>{
        return repository.getMissions()
    }

    fun callApi(){
        repository.callApi()
    }
}