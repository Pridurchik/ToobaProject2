package com.hackton.toobaproject2.ui.compsable.comp

import androidx.collection.mutableObjectListOf
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hackton.toobaproject2.R

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MyDonations(
) {

    val bottomSheetState = rememberModalBottomSheetState()
    var isBottomSheetVisible by remember { mutableStateOf(false) }

    val city = mutableObjectListOf(
        "г.Каспий",
        "г.Махачкала",
        "г.Избербаш",
        "Агульский р-он",
        "Акушинский р-он"
    )
    var selectedCity by rememberSaveable { mutableStateOf("г.Каспий") }

    Column {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, end = 25.dp, top = 15.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 2.dp),
                    text = "Интересное",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )

                Spacer(
                    modifier = Modifier.weight(1f)
                )

                Text(
                    modifier = Modifier.clickable {
                        isBottomSheetVisible = !isBottomSheetVisible
                    },
                    text = "Фильтры",
                )
            }
        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, end = 25.dp)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp)
            ) {
                items(count = 1) {
                    CollectionItemOne()
                }
            }
        }

    }

    if (isBottomSheetVisible) {
        ModalBottomSheet(
            sheetState = bottomSheetState,
            onDismissRequest = { isBottomSheetVisible = false },
        ) {
            Column(
                modifier = Modifier.padding(start = 25.dp, end = 25.dp),
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 2.dp),
                    text = "Категории",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )

                FlowRow {
                    city.forEach { itemCity ->

                        FilterChip(
                            modifier = Modifier.padding(end = 10.dp),
                            selected = selectedCity == itemCity,
                            onClick = { selectedCity = itemCity },
                            label = { Text(itemCity) },

                            )

                    }

                    Box {
                        Text(
                            modifier = Modifier.padding(top = 12.dp),
                            text = "Другие",
//                            color = Color(0xFF307B75)
                        )
                    }
                }
            }
        }
    }

}

@Composable
private fun CollectionItemOne() {

    val progress = remember { mutableFloatStateOf(0.25f) }

    Card(
        modifier = Modifier
            .padding(bottom = 20.dp)
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(8.dp),
            )
            .clickable {
            },
        colors = CardDefaults.cardColors(containerColor = Color.White),
    ) {
        Column {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(R.drawable.dcp2),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )

            Row(
                modifier = Modifier.padding(15.dp)

            ) {
                Column {
                    Text(
                        text = "Помощь ребенку ДЦП-ку",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )


                    Row(
                        modifier = Modifier.padding(top = 15.dp)
                    ) {
                        Text(
                            text = "4.563 ₽ ",
//                            color = Color(0xFF307B75)
                        )

                        Text(
                            text = "собрали | ",
//                            color = Color(0xFF6C7278)
                        )

                        Text(
                            text = "2 ",
//                            color = Color(0xFF307B75)
                        )

                        Text(
                            text = "дня назад",
//                            color = Color(0xFF6C7278)
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val infiniteTransition = rememberInfiniteTransition()

                    val animatedProgress by animateFloatAsState(
                        targetValue = 1.0f,
                        animationSpec = infiniteRepeatable(
                            animation = tween(900),
                        )
                    )

                    CircularProgressIndicator(
                        modifier = Modifier.size(28.dp),
                        color = Black.copy(alpha = 0.2f),
                        strokeWidth = (1.5).dp,
                        trackColor = Black,
                    )


                }
            }
        }
    }
}
