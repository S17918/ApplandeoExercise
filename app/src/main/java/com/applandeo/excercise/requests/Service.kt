package com.applandeo.excercise.requests

import com.applandeo.excercise.requests.responses.MissionResponse
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET

interface Service {
    @GET("missions")
    fun getMissions() : Flowable<List<MissionResponse>>
}