package com.example.assignmentfinal.ui.theme

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AssignmentViewModel : ViewModel() {
    private val _lists = MutableStateFlow<List<Int>>(listOf(1000))
    val lists = _lists.asStateFlow()
    private val _count = MutableStateFlow(0)
    val count = _count.asStateFlow()

    companion object {
        private const val TAG = "Assignment_vm"
    }

    private var count1 = 1

    fun firstScreenSeries() {
        val numList = mutableListOf<Int>()
        var n = 10
        for (i in 0 until count.value) {
            val newValue = if (n % 2 == 0) n * 100 else -n * 100

            numList.add(newValue)
            Log.d("value.1", "$newValue")

            n -= 1
        }
        Log.d("List", numList.toString())
        count1 += 1
        _count.update { count1 }
        _lists.update { numList }
        Log.d("Lists", _lists.value.toString())
    }



//
//val newList = _lists.updateAndGet {
//            val lastItem = it.lastOrNull()
//            val newList = mutableListOf<Int>()
//            if (lastItem == null || it.isEmpty()) {
//                newList.add(1000)
//            } else if (lastItem < 0) {
//                newList.addAll(it)
//                val a = lastItem.times(-1)
//                val b = a.minus(100)
//                newList.add(b)
//            } else {
//                newList.addAll(it)
//                val a = lastItem.times(-1)
//                val b = a.plus(100)
//                newList.add(b)
//            }
//            newList
//        }
//        Log.v(TAG + "_new", newList.toString())
//    }
}

