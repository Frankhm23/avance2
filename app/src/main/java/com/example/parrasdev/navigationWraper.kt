package com.example.parrasdev

import LoginScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.parrasdev.presentation.home.HomeScreen
import com.example.parrasdev.presentation.initial.InitialScreen
import com.example.parrasdev.presentation.singup.SingupScren
import com.google.firebase.auth.FirebaseAuth

@Composable

fun NavigationWrapper(navHostController: NavHostController, auth: FirebaseAuth) {
    NavHost(navController = navHostController, startDestination = "initial") {
        composable("initial") {
            InitialScreen(
                navigateToLogin = { navHostController.navigate("login") },
                navigateToSingUp = { navHostController.navigate("singup") }

            )
        }
        composable("login") {
            LoginScreen(auth){navHostController.navigate("home")}
        }
        composable("singup") {
            SingupScren(auth)
        }
        composable("home"){
            val navigateToLogout = {
                navHostController.navigate("initial") {
                    popUpTo("home") { inclusive = true }
                }
            }

            HomeScreen(navigateToLogout = navigateToLogout)

        }

    }
}