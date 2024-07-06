package com.example.assignmentfinal.ui.theme

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Screen2(
    onOneButtonClicked: () -> Unit,
    onThreeButtonClicked: () -> Unit

) {
    val viewModel = viewModel<ScreenTwoViewModel>()
    var list by remember { mutableStateOf<List<Int>>(listOf()) }

    val series by viewModel.series.collectAsState()
//    LaunchedEffect(key1 = null) {
//        viewModel.prime.collect {
//            Log.e("value_ok", "$it")
//                    list = it
//        }
//    }


    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                onFirstButtonClicked = onOneButtonClicked,
                onSecondButtonClicked = onThreeButtonClicked,
                onThirdButtonClicked = viewModel::newList,
                firstButton = "1",
                secondButton = "3",
                thirdButton = "Button"
            )
        }
    ) { padding ->
        LazyRow(
            modifier = Modifier.padding(top = 400.dp, start = 40.dp, end = 30.dp),
            horizontalArrangement = Arrangement.spacedBy(30.dp)) {
            items(series) {
                Text(text = it.toString(), fontSize = 25.sp)
                Log.d("value_it", "$it")
            }
        }
    }
}


@Preview
@Composable
private fun Screen2Preview() {
    Screen2(onOneButtonClicked = {}, onThreeButtonClicked = {})


}