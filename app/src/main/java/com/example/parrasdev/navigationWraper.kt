package com.example.parrasdev

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.parrasdev.presentation.initial.IniitalScren
import com.example.parrasdev.presentation.login.LoginScren
import com.example.parrasdev.presentation.singup.singupScren
@Composable

fun NavigationWraper(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "inital"){
        composable("initial"){
            IniitalScren(
                navigateToLogin = {navHostController.navigate("login")},
                navigateToSingUp = {navHostController.navigate("singup")}

            )
        }
        composable("login") {
            LoginScren()
        }
        composable("singup") {
            singupScren()
        }
    }
}
