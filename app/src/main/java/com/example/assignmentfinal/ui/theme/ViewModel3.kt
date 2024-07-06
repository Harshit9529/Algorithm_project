package com.example.assignmentfinal.ui.theme

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class ScreenThreeViewModel : ViewModel() {
    private val _unit = MutableStateFlow<List<Any>>(listOf())
    var unit = _unit.asStateFlow()



    private var count = 0
    private var series = mutableListOf<Any>()
    fun thirdSeries() {
        val sequence = ('a'..'z') + ('a'..'z').map { "a$it" } + ('a'..'z').map { "b$it" }
        val newSeries = if (count < sequence.size) {
            series = (series + sequence[count]).toMutableList()

        }else{}
        count++
        _unit.value = series
        Log.v("value_vm3", "$newSeries")
        Log.v("value_vm4", "${unit.value}")
    }


}