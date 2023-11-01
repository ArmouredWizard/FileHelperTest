package uk.co.maddwarf.filehelpertest.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import uk.co.maddwarf.filehelpertest.R
import uk.co.maddwarf.filehelpertest.TestTopAppBar
import uk.co.maddwarf.filehelpertest.navigation.NavigationDestination
import uk.co.maddwarf.filehelpertest.ui.composables.MyButton
import uk.co.maddwarf.filehelpertest.ui.composables.MySpinner

object HomeDestination : NavigationDestination {
    override val route = "home"
    override val titleRes = R.string.app_name
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier,
    navigateToMapScreen: (String) -> Unit,
    navigateToSettings: () -> Unit,
    homeViewModel: HomeViewModel = viewModel()
) {

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    val sizeList = homeViewModel.sizeList
    val inhabitantsList = homeViewModel.inhabitantsList


    Scaffold(
        modifier = modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TestTopAppBar(
                title = stringResource(HomeDestination.titleRes),
                canNavigateBack = false,
                scrollBehavior = scrollBehavior,
                canNavigateHome = false
            )
        },
     /*   floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToSettings,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings Icon"
                )
            }
        }*/
    ) { innerPadding ->
        HomeBody(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            navigateToMapScreen = navigateToMapScreen,
            sizeList = sizeList,
            inhabitantsList = inhabitantsList
        )
    }//end Scaffold

}//end HomeScreen


@Composable
fun HomeBody(
    modifier: Modifier,
    navigateToMapScreen: (String) -> Unit,
    sizeList: List<String>,
    inhabitantsList: List<String>
) {
    Log.d("HOME BODY", "Loaded")
    var levelList = mutableListOf<String>()
    for (i in 1..20) {
        levelList.add(i.toString())
    }




    var inhabitantsExpanded by remember { mutableStateOf(false) }
    var chosenInhabitants by remember { mutableStateOf(inhabitantsList[0]) }
    fun inhabitantsChooser(inhabitants: String) {
        inhabitantsExpanded = false
        chosenInhabitants = inhabitants
    }





    Box(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.TopCenter)
              //  .background(color = Color.Gray)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ) {
            //Spacer(modifier = Modifier.height(60.dp))


            Column(
                modifier = Modifier.fillMaxSize()
                    .weight(1f)
                   // .background(color = Color.DarkGray),
                ,verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.End

            ) {

                Row(
                    modifier = Modifier
                        .wrapContentWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Inhabitants: ")
                    MySpinner(
                        expanded = inhabitantsExpanded,
                        onClick = { inhabitantsExpanded = !inhabitantsExpanded },
                        list = inhabitantsList,
                        chooser = ::inhabitantsChooser,
                        report = chosenInhabitants
                    )
                }
            }


        }//end outer row
        Row(
            modifier = Modifier
                .wrapContentWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp)
        ){
        MyButton(
            text = "Make the Map!",
            onClick = { },
        )
        }
    }//end Box
}
