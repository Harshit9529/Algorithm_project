package com.example.assignmentfinal.ui.theme

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavigationBar(
    onFirstButtonClicked : () -> Unit,
    onSecondButtonClicked : ()-> Unit,
    onThirdButtonClicked : ()-> Unit,
    firstButton : String,
    secondButton : String,
    thirdButton: String
) {
    NavigationBar(modifier = Modifier) {
        Row {
            Button(
                onClick = onFirstButtonClicked,
                modifier = Modifier.padding( 10.dp)
            ){
                Text(text = firstButton)
            }
            Button(
                onClick = onSecondButtonClicked,
                modifier = Modifier.padding(10.dp)
            ){
                Text(text = secondButton)
            }
            Spacer(modifier = Modifier.padding(50.dp))
            Button(
                onClick = onThirdButtonClicked,
                modifier = Modifier.padding(top = 10.dp)) {
                Text(text = thirdButton)

            }
        }
    }
}

@Preview
@Composable
fun PreviewBottomNavigationBar() {
    BottomNavigationBar(
        onFirstButtonClicked = {},
        onSecondButtonClicked = {},
        onThirdButtonClicked = { },
        firstButton = "",
        secondButton = "" ,
        thirdButton = ""
    )

}