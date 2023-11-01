package uk.co.maddwarf.filehelpertest.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import uk.co.maddwarf.filehelpertest.domain.GetInhabitantsUseCase

class HomeViewModel(application: Application): AndroidViewModel(application) {

    //val context = getApplication<Application>().applicationContext

    val sizeList = listOf("Small", "Medium", "Large", "Huge")
    val inhabitantsList: List<String> = GetInhabitantsUseCase().getInhabitantsCategories()

}
