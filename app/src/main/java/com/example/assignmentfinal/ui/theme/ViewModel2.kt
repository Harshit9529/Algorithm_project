package com.example.assignmentfinal.ui.theme

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.updateAndGet

class ScreenTwoViewModel : ViewModel() {
    private val _prime = MutableStateFlow<List<Int>>(listOf())
    val prime = _prime.asStateFlow()

    private val _uiState = MutableStateFlow<Int>(0)
    val uiState = _uiState.asStateFlow()

    companion object {
        private const val TAG = "Screen2_vm"
    }
//
//    private var temp1 = 0
//    private var temp2 = 1
//    private var count2 = 1


//
//    fun secondSeries() {
//        val numberlis = mutableListOf<Int>()
//
//        for (i in 0..uiState.value) {
////            var sum = temp1 + temp2
//            var count2 = 1
//            val sequence = if (count2 >= 1) temp1 else temp1
//            Log.d("value", "$sequence")
//
//            numberlis.add(sequence)
//            Log.v("numberlis", numberlis.toString())
//
//
//        }
//        val sum = (temp1 + temp2)
//        temp2.also { temp1 = it }
//        temp2 = sum
//        count2++
//
//        Log.d("list_value", "$numberlis")
//
//        _uiState.update { count2 }
//        val a = _prime.updateAndGet { numberlis }
//        Log.v("list_values", a.toString())
//    }

    private val _series = MutableStateFlow<List<Long>>(listOf(0, 1))
    val series = _series.asStateFlow()

    fun newList() {
        val x =  _series.updateAndGet {
            val newSeries = it.toMutableList()
            newSeries.add(it[it.size - 2] + it[it.size - 1])
            newSeries
        }
        Log.d(TAG, x.toString())
    }
}
