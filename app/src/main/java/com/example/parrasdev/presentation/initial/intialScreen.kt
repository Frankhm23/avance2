package com.example.parrasdev.presentation.initial

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parrasdev.R
import com.example.parrasdev.ui.theme.BackgroundButton
import com.example.parrasdev.ui.theme.Black
import com.example.parrasdev.ui.theme.Gray
import com.example.parrasdev.ui.theme.Green
import com.example.parrasdev.ui.theme.ShapeButton

@Preview
@Composable

fun InitialScreen(navigateToLogin:() -> Unit = {}, navigateToSingUp:() -> Unit= {}){
    Column (modifier = Modifier.fillMaxSize().background(brush = Brush.verticalGradient(listOf(
        Gray,
        Black), startY = 0f , endY = 600f )),
            horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.weight(1f))
        Image(painter = painterResource(id = R.drawable.pdev), contentDescription = "",
            modifier = Modifier.clip(CircleShape))
        Spacer(modifier = Modifier.weight(1f))
        Text("Access Your Account \n",
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
            )
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = {navigateToSingUp()}, modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp).height(48.dp), colors = ButtonDefaults.buttonColors(containerColor = Green)) {
            Text(text = "Sing up Free", color = Black)
        }
        Spacer(modifier = Modifier.height(8.dp))
        CustomButton(Modifier.clickable {}, painterResource(id = R.drawable.google),"Google")
        Spacer(modifier = Modifier.height(8.dp))
        CustomButton(Modifier.clickable {}, painterResource(id = R.drawable.facebook),"Facebook")
        Text(
            text = "Log in",
            color = Color.White,
            modifier = Modifier
                .padding(24.dp)
                .clickable { navigateToLogin() }
        )
        Spacer(modifier = Modifier.height(24.dp))
    }
}
@Composable
fun CustomButton(modifier: Modifier, painter: Painter, title: String){
    Box(modifier = Modifier
            .fillMaxWidth().
            height(48.dp)
            .padding(horizontal = 32.dp).background(BackgroundButton).border(2.dp, ShapeButton, CircleShape), contentAlignment = Alignment.CenterStart
    ) {
        Image(painter = painter,
            contentDescription = "",
            modifier = Modifier.padding(start = 16.dp).size(15.dp)
        )
    Text(
        text = title ,
        color = Color.White,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
    }

}



