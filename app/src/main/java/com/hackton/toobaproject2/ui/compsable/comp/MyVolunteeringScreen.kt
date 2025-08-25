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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ProgressIndicatorDefaults
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hackton.toobaproject2.R

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun MyVolunteeringScreen() {


    val bottomSheetState = rememberModalBottomSheetState()
    var isBottomSheetVisible by remember { mutableStateOf(false) }

    val city = mutableObjectListOf("г.Каспий", "г.Махачкала", "г.Избербаш", "Агульский р-он", "Акушинский р-он")
    var selectedCity by rememberSaveable { mutableStateOf("г.Каспий") }

    Column {


        Column(
            modifier = Modifier.fillMaxWidth().padding(start = 25.dp, end = 25.dp)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(top = 10.dp)
            ) {
                items(count = 1) {
                    CollectionItemOne()
                    CollectionItemTwo()
                }
            }
        }

    }

    if(isBottomSheetVisible) {
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
                            color = Color(0xFF307B75)
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

    val animatedProgress by animateFloatAsState(
        targetValue = progress.value,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec,
    )

    Card(
        modifier = Modifier.padding(bottom = 20.dp).shadow(
            elevation = 4.dp,
            shape = RoundedCornerShape(8.dp),
        ),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(R.drawable.subb),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )

            Row(
                modifier = Modifier.padding(15.dp)

            ) {
                Column {
                    Text(
                        text = "Субботник в городе 2025",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )


                    Row(
                        modifier = Modifier.padding(top = 15.dp)
                    ) {
                        Text(
                            text = "Принято участие - 25.07.2025",
                            color = Color(0xFF307B75)
                        )
                    }
                }

                Column(
                    modifier = Modifier.fillMaxWidth().padding(start = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    val animatedProgress by animateFloatAsState(
                        targetValue = 1.0f,
                        animationSpec = infiniteRepeatable(
                            animation = tween(900),
                        )
                    )

                    CircularProgressIndicator(
                        progress = { animatedProgress },
                        trackColor = Color(0xFFD9D9D9)
                    )

                    Text(
                        modifier = Modifier.padding(top = 5.dp),
                        text = "100%"
                    )


                }
            }
        }
    }
}

@Composable
private fun CollectionItemTwo() {

    val progress = remember { mutableFloatStateOf(0.25f) }

    val animatedProgress by animateFloatAsState(
        targetValue = progress.value,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec,
    )

    Card(
        modifier = Modifier.padding(bottom = 20.dp).shadow(
            elevation = 4.dp,
            shape = RoundedCornerShape(8.dp),
        ),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(R.drawable.subb2),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )

            Row(
                modifier = Modifier.padding(15.dp)

            ) {
                Column {
                    Text(
                        text = "Субботник в городе 2024",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )


                    Row(
                        modifier = Modifier.padding(top = 15.dp)
                    ) {
                        Text(
                            text = "Принято участие - 25.07.2024",
                            color = Color(0xFF307B75)
                        )
                    }
                }

                Column(
                    modifier = Modifier.fillMaxWidth().padding(start = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    val animatedProgress by animateFloatAsState(
                        targetValue = 1.0f,
                        animationSpec = infiniteRepeatable(
                            animation = tween(900),
                        )
                    )

                    CircularProgressIndicator(
                        progress = { animatedProgress },
                        trackColor = Color(0xFFD9D9D9)
                    )

                    Text(
                        modifier = Modifier.padding(top = 5.dp),
                        text = "100%"
                    )


                }
            }
        }
    }
}
