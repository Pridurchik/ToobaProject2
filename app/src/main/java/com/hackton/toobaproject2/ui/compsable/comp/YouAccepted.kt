package com.hackton.toobaproject2.ui.compsable.comp

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun YouAccepted() {

    Column(
        modifier = Modifier,

    ) {


        Text(
            text = "Ваша заявка одобрена!"
        )
    }

}