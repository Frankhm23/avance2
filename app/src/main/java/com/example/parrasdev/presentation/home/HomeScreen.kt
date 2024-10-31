@file:Suppress("UNUSED_EXPRESSION")

package com.example.parrasdev.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parrasdev.R
import com.example.parrasdev.ui.theme.Black
import com.example.parrasdev.ui.theme.Gray
import com.google.firebase.auth.FirebaseAuth


@Composable
fun HomeScreen(navigateToLogout:() -> Unit) {
    val auth = FirebaseAuth.getInstance()
    val userEmail = auth.currentUser?.email ?: "user@example.com"
    Column (modifier = Modifier.fillMaxSize().background(brush = Brush.verticalGradient(listOf(
        Gray,
        Black
    ), startY = 0f , endY = 600f )),
        horizontalAlignment = Alignment.CenterHorizontally ) {
        Spacer(modifier = Modifier.weight(1f))
        Image(painter = painterResource(id = R.drawable.accountwhite), contentDescription = "",
            modifier = Modifier.size(70.dp))
        Spacer(modifier = Modifier.weight(1f))
        Text("Welcome Back Sailor $userEmail \n",
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(8f))
        Text(text = "Email \n")
        Spacer(modifier = Modifier.weight(8f))

        Button(
            onClick = {
                    auth.signOut()
                    navigateToLogout()
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text(text = "Logout", color = Color.White)
        }
        Spacer(modifier = Modifier.weight(1f))




    }

}
