package uk.co.maddwarf.filehelpertest.domain

import uk.co.maddwarf.filehelpertest.repository.InhabitantsRepository

class GetInhabitantsUseCase() {
    fun getInhabitantsCategories(): List<String> {
        val categories = InhabitantsRepository().getCategoriesList(table = "inhabitants")

        //call File Helper

        return categories
    }


}
