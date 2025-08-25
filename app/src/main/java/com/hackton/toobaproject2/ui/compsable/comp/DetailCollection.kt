package com.hackton.toobaproject2.ui.compsable.comp

import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hackton.toobaproject2.R

@Composable
fun DetailCollection(
    navigateToCollectionScreen: () -> Unit,
) {
    val context = LocalContext.current

    val scrollableState = rememberScrollState()

    Column(
        modifier = Modifier.padding(horizontal = 20.dp)
            .verticalScroll(scrollableState)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10)),
            painter = painterResource(R.drawable.dcp),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Сбор на лечение ДЦП",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Махачкала",
            color = Color(color = 0xFF307B75),
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Дорогие люди, просим вас\n" +
                    "принять участие в помоще нашего\n" +
                    "ребенке в лечении болезни ДЦП",
            fontSize = 19.sp,
            maxLines = 3,
        )


        Spacer(modifier = Modifier.height(30.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .padding(start = 15.dp, top = 10.dp, bottom = 10.dp)
                        .size(50.dp),
                    painter = painterResource(R.drawable.user_icon),
                    contentDescription = null
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(start = 15.dp),
                        text = "Магомедов Гарун Мусалиф.",
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.width(5.dp))

                    Icon(
                        modifier = Modifier.size(20.dp),
                        painter = painterResource(R.drawable.verify),
                        contentDescription = null
                    )
                }
            }
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(
            text = "Откликнулось",
            fontSize = 18.sp
        )

        Row(
            modifier = Modifier.padding(vertical = 10.dp)
        ) {
            Text(
                text = "14 ",
                fontWeight = FontWeight.Bold,
                fontSize = 19.sp
            )

            Text(
                text = "/ 20 людей",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6C7278),
                fontSize = 19.sp
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {


            LinearProgressIndicator(
                progress = 0.7f,
                trackColor = Color(0xFFD9D9D9),
                color = Color(0xFFFD7123),
                modifier = Modifier.weight(1f).height(10.dp).clip(RoundedCornerShape(10.dp))

            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(
                text = "70%"
            )

        }

        Button(
            modifier = Modifier.padding(top = 30.dp).fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF307B75)),
            shape = RoundedCornerShape(15),
            onClick = {
                Toast.makeText(context, "Вы записаны!", Toast.LENGTH_SHORT).show()
                android.os.Handler.createAsync(Looper.getMainLooper()).post {
                    Thread.sleep(1000)
                    navigateToCollectionScreen.invoke()
                }
            },
        ) {
            Text(
                modifier = Modifier.padding(vertical = 6.dp),
                text = "Принять участие",
                fontSize = 16.sp
            )
        }
    }
}

