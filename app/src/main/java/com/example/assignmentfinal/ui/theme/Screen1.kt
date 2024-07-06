package com.example.assignmentfinal.ui.theme

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
fun Screen1(
    onTwoButtonClicked: () -> Unit,
    onThreeButtonClicked: () -> Unit,
) {
    val viewModel = viewModel<AssignmentViewModel>()
    var list by remember { mutableStateOf<List<Int>>(listOf()) }

    LaunchedEffect(key1 = null) {
        viewModel.lists.collect {
            Log.d("screen_", it.toString())
            list = it
        }
    }

    Scaffold(bottomBar = {
        BottomNavigationBar(
            onFirstButtonClicked = onTwoButtonClicked,
            onSecondButtonClicked = onThreeButtonClicked,
            onThirdButtonClicked = { viewModel.firstScreenSeries() },
            firstButton = "2",
            secondButton = "3",
            thirdButton = "Button"
        )
    }) { padding ->
        LazyColumn(modifier = Modifier.padding(100.dp)) {
            items(list) {
                Log.d("screen_value", it.toString())
                Text(text = it.toString(), modifier = Modifier.padding(60.dp) , fontSize = 25.sp)
            }
        }
    }
}


@Preview
@Composable
private fun Screen1Preview() {
    Screen1(onTwoButtonClicked = {}, onThreeButtonClicked = {})
}