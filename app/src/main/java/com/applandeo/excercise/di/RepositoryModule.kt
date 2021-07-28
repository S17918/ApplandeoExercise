package com.applandeo.excercise.di

import com.applandeo.excercise.repositories.MissionRepository
import com.applandeo.excercise.repositories.MissionRepositoryImpl
import com.applandeo.excercise.ui.presentation.mission_list.MissionListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object RepositoryModule {
    val repositoryModule : Module = module {
        single<MissionRepository> { MissionRepositoryImpl() }
        viewModel { MissionListViewModel(get()) }
    }
}