package com.example.parrasdev

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.parrasdev.presentation.initial.IniitalScren
import com.example.parrasdev.presentation.login.LoginScren
import com.example.parrasdev.presentation.singup.SingupScren
import com.google.firebase.auth.FirebaseAuth
@Composable

fun NavigationWraper(navHostController: NavHostController, auth: FirebaseAuth) {
    NavHost(navController = navHostController, startDestination = "inital"){
        composable("initial"){
            IniitalScren(
                navigateToLogin = {navHostController.navigate("login")},
                navigateToSingUp = {navHostController.navigate("singup")}

            )
        }
        composable("login") {
            LoginScren(auth)
        }
        composable("singup") {
            SingupScren(auth)
        }
    }
}
