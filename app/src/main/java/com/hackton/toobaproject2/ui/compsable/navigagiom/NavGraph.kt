package com.hackton.toobaproject2.ui.compsable.navigagiom

import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(
    navController: NavHostController,
    collectionListContent: @Composable () -> Unit,
    profileContent: @Composable () -> Unit,
    volunteeringContent: @Composable () -> Unit,
    detailCollectionContent: @Composable () -> Unit,
    detailVolunteeringContent: @Composable () -> Unit,
    myVolunteeringContent: @Composable () -> Unit,
    myDonationsContent: @Composable () -> Unit,
    youAcceptedContent: @Composable () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = Screens.CollectionList.route
    ) {
        composable(
            route = Screens.CollectionList.route
        ) { collectionListContent.invoke() }

        composable(
            route = Screens.ProfileScreen.route
        ) { profileContent.invoke() }

        composable(
            route = Screens.VolunteeringScreen.route
        ) { volunteeringContent.invoke() }

        composable(
            route = Screens.DetailCollectionScreen.route
        ) { detailCollectionContent.invoke() }

        composable(
            route = Screens.DetailCollectionScreen.route
        ) { detailCollectionContent.invoke() }

        composable(
            route = Screens.DetailVolunteeringScreen.route
        ) { detailVolunteeringContent.invoke() }

        composable(
            route = Screens.MyVolunteeringScreen.route
        ) { myVolunteeringContent.invoke() }

        composable(
            route = Screens.MyDonationScreen.route
        ) { myDonationsContent.invoke() }

        composable(
            route = Screens.YouAccepted.route
        ) { youAcceptedContent.invoke() }
    }
}