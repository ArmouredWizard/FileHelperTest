package uk.co.maddwarf.filehelpertest.repository

import android.content.Context
import android.util.Log
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import java.io.BufferedReader

class JsonHelper(val context: Context) {

    fun readAsset(fileName: String): String =
        context
            .assets
            .open(fileName)
            .bufferedReader()
            .use(BufferedReader::readText)
//end readAsset

    fun getCategoriesList(table: String): List<String> {
        Log.d("JSON HELPER", "Begun")
        val theJsonString: String =
            readAsset(fileName = "$table.json")
        val theJsonObject: JsonObject =
            JsonParser.parseString(theJsonString).asJsonObject!!

        val categories = mutableListOf<String>()
        val theNames = theJsonObject.keySet()

        for (element in theNames) {
            categories.add(element)
        }
        return categories.sorted()
    }
}