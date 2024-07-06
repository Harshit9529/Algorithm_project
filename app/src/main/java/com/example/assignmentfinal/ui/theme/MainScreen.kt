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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


enum class AssignmentScreen{
    Screen1,
    Screen2,
    Screen3
}


@Composable
fun MainScreen() {
    val navcontrolller = rememberNavController()

    NavHost(
        navController = navcontrolller,
        startDestination = AssignmentScreen.Screen1.name
    ) {
        composable(route = AssignmentScreen.Screen1.name){
            Screen1(
                onTwoButtonClicked = {navcontrolller.navigate(AssignmentScreen.Screen2.name)},
                onThreeButtonClicked = {navcontrolller.navigate(AssignmentScreen.Screen3.name)},
            )
        }
        composable(route = AssignmentScreen.Screen2.name){
            Screen2(
                onOneButtonClicked = {navcontrolller.navigate(AssignmentScreen.Screen1.name)},
                onThreeButtonClicked = {navcontrolller.navigate(AssignmentScreen.Screen3.name)}
            )
        }
        composable(route = AssignmentScreen.Screen3.name){
            Screen3(
                onTwoButtonClicked = {navcontrolller.navigate(AssignmentScreen.Screen2.name)},
                onOneButtonClicked = {navcontrolller.navigate(AssignmentScreen.Screen1.name)}
            )
        }

    }
}