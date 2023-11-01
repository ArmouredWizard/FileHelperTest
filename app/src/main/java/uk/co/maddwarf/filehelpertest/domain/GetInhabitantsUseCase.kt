package uk.co.maddwarf.filehelpertest.domain

import android.util.Log
import uk.co.maddwarf.filehelpertest.repository.InhabitantsRepository
import uk.co.maddwarf.filehelpertest.repository.JsonHelper

class GetInhabitantsUseCase(val jsonHelper: JsonHelper) {
    fun getInhabitantsCategories(): List<String> {
        Log.d("UseCse", "Inhabitants get categories")
        val categories =
            InhabitantsRepository(jsonHelper = jsonHelper).getCategoriesList(table = "inhabitants")

        //call File Helper

        return categories
    }


}
