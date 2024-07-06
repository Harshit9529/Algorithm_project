package com.example.assignmentfinal.ui.theme

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
fun Screen3(
    onTwoButtonClicked : ()-> Unit,
    onOneButtonClicked : () -> Unit
) {
    val viewModel = viewModel<ScreenThreeViewModel>()
    var list by remember{ mutableStateOf<List<Any>>(listOf()) }


    LaunchedEffect(key1 = null) {
        viewModel.unit.collect{
            Log.e("value_it" , "$it")
            list = it
        }
    }



    Scaffold (
        bottomBar = {
            BottomNavigationBar(
                onFirstButtonClicked = onTwoButtonClicked,
                onSecondButtonClicked = onOneButtonClicked,
                onThirdButtonClicked = {viewModel.thirdSeries()},
                firstButton = "2",
                secondButton = "1",
                thirdButton = "Button"
            )
        }
    ) {padding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(3) ,
            modifier = Modifier
                .padding(
                    top = 80.dp,
                    bottom = 150.dp
                )
        ){
            items(list){
                Text(text = it.toString() , fontSize = 25.sp , modifier = Modifier.padding(60.dp))
                Log.d("val_it" , "$it")
            }
        }

    }


}



@Preview
@Composable
private fun Screen3Preview() {
    Screen3(onTwoButtonClicked = {}, onOneButtonClicked = {})


}