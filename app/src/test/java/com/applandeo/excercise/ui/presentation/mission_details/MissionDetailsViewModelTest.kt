package com.applandeo.excercise.ui.presentation.mission_details

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.applandeo.excercise.models.Mission
import com.applandeo.excercise.repositories.MissionRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class MissionDetailsViewModelTest : LifecycleOwner {

    private lateinit var viewModel: MissionDetailsViewModel

    @Mock
    private lateinit var observer: Observer<Mission>

    @BeforeEach
    fun init(){
        MockitoAnnotations.initMocks(this)
        viewModel = MissionDetailsViewModel()
    }

    @Test
    fun observeMission_whenSet(){
        val manufacturers = listOf<String>("TEST", "TEST", "TEST")
        val payloads = listOf<String>("TEST", "TEST", "TEST")
        val mission: Mission = Mission("TEST","TEST", manufacturers, payloads, "TEST","TEST","TEST","TEST")

        viewModel.setMission(mission)

        viewModel.getMission().observeForever(observer)
        println(observer.toString())
    }

    override fun getLifecycle(): Lifecycle {
        TODO("Not yet implemented")
    }
}