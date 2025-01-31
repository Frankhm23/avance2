package com.example.parrasdev.presentation.singup


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parrasdev.R
import com.example.parrasdev.ui.theme.Purple40
import com.example.parrasdev.ui.theme.UnselectedField
import com.google.firebase.auth.FirebaseAuth

@Composable


fun SingupScren(auth: FirebaseAuth) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().background(brush = Brush.verticalGradient(listOf(Gray,
        Purple40)))
        .padding(horizontal = 32.dp)
    ) {
        Row(){
            Icon(
                painter = painterResource(id = R.drawable.back),
                contentDescription = "",
                tint = White,
                modifier = Modifier
                    .padding(vertical = 24.dp)
                    .size(24.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
        }
        Text("Email", color = White, fontWeight = FontWeight.Bold, fontSize = 40.sp)
        TextField(value = email, onValueChange = { email = it }, modifier = Modifier.fillMaxWidth(), colors = TextFieldDefaults.colors(
            unfocusedContainerColor = UnselectedField,
            focusedContainerColor = UnselectedField
        ))
        Spacer(Modifier.height(48.dp))

        Text("Password", color = White, fontWeight = FontWeight.Bold, fontSize = 40.sp)
        TextField(value = password, onValueChange = { password = it }, modifier = Modifier.fillMaxWidth(), colors = TextFieldDefaults.colors(
            unfocusedContainerColor = UnselectedField,
            focusedContainerColor = UnselectedField
        )
        )
        Spacer(Modifier.height(48.dp))
        Button(onClick = {
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{ task ->
                if(task.isSuccessful){

                    Log.i("aris", "Registro OK")
                }else{
                    //Error
                    Log.i("aris", "Registro KO")
                }
            }
        }) {
            Text(text = "Sing Up")
        }
    }

}