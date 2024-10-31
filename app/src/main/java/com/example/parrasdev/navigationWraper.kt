package com.example.parrasdev

import LoginScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.parrasdev.presentation.initial.IniitalScren
import com.example.parrasdev.presentation.singup.SingupScren
import com.google.firebase.auth.FirebaseAuth

@Composable

fun NavigationWrapper(navHostController: NavHostController, auth: FirebaseAuth) {
    NavHost(navController = navHostController, startDestination = "initial"){
        composable("initial"){
            IniitalScren(
                navigateToLogin = {navHostController.navigate("login")},
                navigateToSingUp = {navHostController.navigate("singup")}

            )
        }
        composable("login") {
            LoginScreen(auth)
        }
        composable("singup") {
            SingupScren(auth)
        }
    }
}
