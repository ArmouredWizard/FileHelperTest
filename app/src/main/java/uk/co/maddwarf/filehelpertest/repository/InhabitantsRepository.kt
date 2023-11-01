package uk.co.maddwarf.filehelpertest.repository

class InhabitantsRepository {


    fun getCategoriesList(table: String): List<String> {

        val context =
        val categories = JsonHelper(context = context).getCategoriesList(table = table)

        return categories
    }

}
