package uk.co.maddwarf.filehelpertest.repository

import android.util.Log

class InhabitantsRepository(val jsonHelper: JsonHelper) {

    fun getCategoriesList(table: String): List<String> {
        Log.d("REPO", "Get categories")
        val categories = jsonHelper.getCategoriesList(table = table)

        return categories
    }

}
