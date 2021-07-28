package com.applandeo.excercise.requests

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.applandeo.excercise.models.Mission
import com.applandeo.excercise.requests.responses.MissionResponse
import io.reactivex.rxjava3.schedulers.Schedulers

class ClientApi{
    private val missions: MutableLiveData<List<Mission>> = MutableLiveData()

    fun getMissions(): LiveData<List<Mission>> {
        return missions
    }

    fun callApi() {
        val service: Service = Client().buildService()
        service.getMissions()
            .toObservable()
            .subscribeOn(Schedulers.io())
            .subscribe(
                {response -> onResponse(response)},
                {error -> onFailure(error)}
            )
    }

    private fun onFailure(error: Throwable) {
        Log.d("TAG", "\n\nResponse = $error")
    }

    private fun onResponse(response: List<MissionResponse>) {
        val list = ArrayList<Mission>()
        for(singleResponse: MissionResponse in response){
            val obj: Mission = Mission(
                singleResponse.mission_name,
                singleResponse.mission_id,
                singleResponse.manufacturers,
                singleResponse.payload_ids,
                singleResponse.wikipedia,
                singleResponse.website,
                singleResponse.twitter,
                singleResponse.description
            )

            list.add(obj)
        }
        missions.postValue(list)
    }
}