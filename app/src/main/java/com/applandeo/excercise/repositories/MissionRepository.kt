package com.applandeo.excercise.repositories

import androidx.lifecycle.LiveData
import com.applandeo.excercise.models.Mission

interface MissionRepository {
    fun getMissions(): LiveData<List<Mission>>
    fun callApi()
}