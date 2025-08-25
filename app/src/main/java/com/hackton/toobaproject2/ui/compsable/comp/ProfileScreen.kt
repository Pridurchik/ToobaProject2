package com.hackton.toobaproject2.ui.compsable.comp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hackton.toobaproject2.R

@Composable
fun ProfileScreen(
    nameAndSurname: String,
    patronimic: String,
    navigateToMyVolunteeringScreen: () -> Unit,
    navigationToMyDonationsScreen: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 35.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            modifier = Modifier.padding(bottom = 20.dp),
            painter = painterResource(R.drawable.user_icon),
            contentDescription = null
        )

        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = "${nameAndSurname}\n${patronimic}",
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Button(
            modifier = Modifier.padding(top = 40.dp).fillMaxWidth().shadow(20.dp),
            onClick = {},
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {

            Text(
                modifier = Modifier.padding(vertical = 6.dp),
                text = "Избранное",
                color = Color.Black
            )
        }


        Button(
            modifier = Modifier.padding(top = 40.dp).fillMaxWidth().shadow(20.dp),
            onClick = {
                navigateToMyVolunteeringScreen.invoke()
            },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {

            Text(
                modifier = Modifier.padding(vertical = 6.dp),
                text = "Мои участия",
                color = Color.Black
            )
        }

        Button(
            modifier = Modifier.padding(top = 20.dp).fillMaxWidth()
                .shadow(20.dp),
            onClick = {
                navigationToMyDonationsScreen.invoke()
            },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {

            Text(
                modifier = Modifier.padding(vertical = 6.dp),
                text = "Мои пожертвования",
                color = Color.Black
            )
        }

        Button(
            modifier = Modifier.padding(top = 20.dp).fillMaxWidth()
                .shadow(20.dp),
            onClick = {
            },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {

            Text(
                modifier = Modifier.padding(vertical = 6.dp),
                text = "Мои достижения",
                color = Color.Black
            )
        }


    }

}