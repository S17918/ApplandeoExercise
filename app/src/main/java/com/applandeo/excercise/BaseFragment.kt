package com.applandeo.excercise

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.applandeo.excercise.models.Mission
import com.applandeo.excercise.requests.Client
import com.applandeo.excercise.requests.Service
import com.applandeo.excercise.requests.responses.MissionResponse
import io.reactivex.rxjava3.schedulers.Schedulers

class BaseFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_base, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        testRetrofit()
    }

    private fun testRetrofit() {
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
        println("---- WYNIK ----\n${response.size}")
    }
}