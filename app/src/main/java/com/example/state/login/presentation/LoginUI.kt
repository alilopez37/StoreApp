package com.example.state.login.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//@Preview(showBackground = true)
@Composable
fun LoginScreen(loginViewModel: LoginViewModel, navigateToHome : () -> Unit ) {
    val number:Int by loginViewModel.number.observeAsState(initial = 0)

    //var number by rememberSaveable { mutableStateOf(0) }
    Column(modifier = Modifier
        .fillMaxSize()
        ) {
        ContainerTop(Modifier.weight(1f), onClick =  {loginViewModel.onChangedNumber()}, onNavigate = {navigateToHome()})
        ContainerCenter(Modifier.weight(1f), onClick = {loginViewModel.onChangedNumber()})
        ContainerBottom(number,Modifier.weight(1f))
    }
}

@Composable
fun ContainerTop(modifier: Modifier, onClick : ()->Unit, onNavigate : () -> Unit){
    Box(
        modifier =  modifier.background(Color.Blue),
        contentAlignment = Alignment.Center
    ){
        Button(
            onClick = { onNavigate()},
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "Click",
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun ContainerCenter(modifier: Modifier, onClick : ()->Unit) {
    Box(
        modifier =  modifier.background(Color.Gray),
        contentAlignment = Alignment.Center
    ){
        Button(
            onClick = { onClick() },
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "Click",
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun ContainerBottom(count: Int,modifier: Modifier) {
    Box(
        modifier =  modifier.fillMaxWidth()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Total de clicks: $count",
            fontSize = 25.sp
        )
    }
}