package uk.co.maddwarf.filehelpertest.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uk.co.maddwarf.filehelpertest.home.HomeDestination
import uk.co.maddwarf.filehelpertest.home.HomeScreen

@Composable
fun FileHelperTestNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val startSize = "Small"
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        //  startDestination = MapScreenDestination.route,
        modifier = modifier
    ) {

        fun navigateToHome() = navController.navigate(HomeDestination.route)

        composable(route = HomeDestination.route) {
            HomeScreen(
                modifier = Modifier,
                navigateToMapScreen = { /*navController.navigate("${MapScreenDestination.route}/${it}") */},
                navigateToSettings = {},//todo add Settings destination
            )
        }//end Home composable


        /*
                composable(route = NpcDisplayDestination.route) {
                    NpcDisplayScreen(
                        //  navigateToHome = { navigateToHome() },
                    )

                }//end  Display screen
        */

    }//end NavHost
}//end DitDNavHost