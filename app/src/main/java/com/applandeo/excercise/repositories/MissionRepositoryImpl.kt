package com.applandeo.excercise.repositories

import androidx.lifecycle.LiveData
import com.applandeo.excercise.models.Mission
import com.applandeo.excercise.requests.ClientApi

class MissionRepositoryImpl : MissionRepository{
    private val clientApi: ClientApi = ClientApi()

    override fun getMissions(): LiveData<List<Mission>> {
        return clientApi.getMissions()
    }

    override fun callApi(){
        clientApi.callApi()
    }
}