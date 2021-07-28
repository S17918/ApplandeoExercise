package com.applandeo.excercise.repositories

import androidx.lifecycle.LiveData
import com.applandeo.excercise.models.Mission
import com.applandeo.excercise.requests.ClientApi

class MissionRepository {

    private val clientApi: ClientApi = ClientApi()

    fun getMissions(): LiveData<List<Mission>> {
        return clientApi.getMissions()
    }

    fun callApi(){
        clientApi.callApi()
    }
}