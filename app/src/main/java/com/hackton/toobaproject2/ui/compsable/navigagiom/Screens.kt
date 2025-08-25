package com.hackton.toobaproject2.ui.compsable.navigagiom

sealed class Screens(
    val route: String
) {

    data object CollectionList: Screens(COLLECTION_LIST_ROUTE)
    data object ProfileScreen: Screens(PROFILE_SCREEN_ROUTE)
    data object VolunteeringScreen: Screens(VOLUNTEERING_SCREEN_ROUTE)
    data object DetailCollectionScreen: Screens(DETAIL_COLLECTION_SCREEN_ROUTE)
    data object DetailVolunteeringScreen: Screens(DETAIL_VOLUNTEERING_SCREEN_ROUTE)
    data object MyVolunteeringScreen: Screens(MY_VOLUNTEERING_SCREEN_ROUTE)
    data object MyDonationScreen: Screens(MY_DONATION_SCREEN_ROUTE)
    data object YouAccepted: Screens(YOU_ACCEPTED_ROUTE)

    private companion object {

        const val COLLECTION_LIST_ROUTE = "collection_list_route"
        const val PROFILE_SCREEN_ROUTE = "profile_screen_route"
        const val VOLUNTEERING_SCREEN_ROUTE = "volunteering_screen_route"
        const val DETAIL_COLLECTION_SCREEN_ROUTE = "detail_collection_screen_route"
        const val DETAIL_VOLUNTEERING_SCREEN_ROUTE = "detail_volunteering_screen_route"
        const val MY_VOLUNTEERING_SCREEN_ROUTE = "my_volunteering_screen_route"
        const val MY_DONATION_SCREEN_ROUTE = "my_donation_screen_route"
        const val YOU_ACCEPTED_ROUTE = "you_accepted_route"

    }
}