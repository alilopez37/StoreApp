package com.example.state.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.state.login.presentation.LoginScreen
import com.example.state.login.presentation.LoginViewModel
import com.example.state.register.presentation.RegisterScreen
import com.example.state.register.presentation.RegisterViewModel

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login) {
        composable<Login> { LoginScreen(LoginViewModel()) {navController.navigate(Register)} }
        composable<Register> { RegisterScreen(RegisterViewModel()) }
    }
}