package com.hackton.toobaproject2.ui

import androidx.collection.mutableObjectListOf
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.hackton.toobaproject2.R
import com.hackton.toobaproject2.ui.compsable.comp.CollectionList
import com.hackton.toobaproject2.ui.compsable.comp.DetailCollection
import com.hackton.toobaproject2.ui.compsable.comp.DetailVolunteeringScreen
import com.hackton.toobaproject2.ui.compsable.comp.MyDonations
import com.hackton.toobaproject2.ui.compsable.comp.MyVolunteeringScreen
import com.hackton.toobaproject2.ui.compsable.comp.ProfileScreen
import com.hackton.toobaproject2.ui.compsable.comp.VolunteeringScreen
import com.hackton.toobaproject2.ui.compsable.comp.YouAccepted
import com.hackton.toobaproject2.ui.compsable.navigagiom.NavGraph
import com.hackton.toobaproject2.ui.compsable.navigagiom.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    val navItems = mutableObjectListOf("Главная", "Волонтерство", "Профиль")
    var selectedItem by remember { mutableStateOf(0) }

    val navController = rememberNavController()

    var query by remember { mutableStateOf("") }


    Scaffold(bottomBar = {
        BottomAppBar {
            navItems.forEachIndexed { index, element ->
                NavigationBarItem(
                    selected = selectedItem == index,
                    onClick = {
                        when (index) {
                            0 -> {
                                navController.navigate(Screens.CollectionList.route)
                            }

                            1 -> {
                                navController.navigate(Screens.VolunteeringScreen.route)
                            }

                            2 -> {
                                navController.navigate(Screens.ProfileScreen.route)
                            }
                        }
                        selectedItem = index
                    },
                    icon = {
                        when (index) {
                            0 -> Icon(Icons.Default.Home, contentDescription = null)
                            1 -> {
                                Icon(Icons.Default.FavoriteBorder, contentDescription = null)
                            }

                            else -> {
                                Icon(Icons.Default.Person, contentDescription = null)

                            }
                        }
                    },
                )
            }
        }
    }, topBar = {
        TopAppBar(navigationIcon = {
            Icon(
                modifier = Modifier
                    .size(80.dp)
                    .padding(start = 25.dp),
                painter = painterResource(R.drawable.tooba),
                contentDescription = null
            )
        }, title = {
            TextField(
                value = query,
                onValueChange = { query = it },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                placeholder = { Text("Поиск...") },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,

                    )
            )
        })
    }) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            NavGraph(navController = navController,
                collectionListContent = {
                    CollectionList(
                        navigateToDetailCollection = {
                            navController.navigate(Screens.DetailCollectionScreen.route)
                        }
                    )
                },
                profileContent = {
                    ProfileScreen(
                        nameAndSurname = "Гарун Магомедов",
                        patronimic = "Мусалифович",
                        navigateToMyVolunteeringScreen = {
                            navController.navigate(Screens.MyVolunteeringScreen.route)
                        },
                        navigationToMyDonationsScreen = {
                            navController.navigate(Screens.MyDonationScreen.route)
                        }
                    )
                },
                volunteeringContent = {
                    VolunteeringScreen(
                        navigateToDetailVolunteering = {
                            navController.navigate(Screens.DetailVolunteeringScreen.route)
                        }
                    )
                },
                detailCollectionContent = {
                    DetailCollection(
                        navigateToCollectionScreen = {
                            navController.navigate(Screens.CollectionList.route)
                        }
                    )
                },
                detailVolunteeringContent = {
                    DetailVolunteeringScreen(
                        navigateToVolunteeringScreen = {
                            navController.navigate(Screens.DetailVolunteeringScreen.route)
                        }
                    )
                },
                myVolunteeringContent = {
                    MyVolunteeringScreen()
                },
                myDonationsContent = {
                    MyDonations()
                },
                youAcceptedContent = {
                    YouAccepted()
                }
            )
        }
    }

}