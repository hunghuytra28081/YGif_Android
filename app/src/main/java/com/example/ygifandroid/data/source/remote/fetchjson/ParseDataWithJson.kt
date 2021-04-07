package com.example.ygifandroid.data.source.remote.fetchjson

import com.example.ygifandroid.data.model.GifEntry
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class ParseDataWithJson {

    fun getJsonFromUrl(urlString: String): String {
        val url = URL(urlString)
        val httpURLConnect = (url.openConnection() as HttpURLConnection).apply {
            requestMethod = METHOD_GET
            connectTimeout = TIME_OUT
            readTimeout = TIME_OUT
            connect()
        }
        val stringBuilder = StringBuilder()
        if (httpURLConnect.responseCode == 200) {
            val bufferedInputStream = BufferedInputStream(httpURLConnect.inputStream) as InputStream
            val bufferedReader = BufferedReader(InputStreamReader(bufferedInputStream.buffered()))
            var line: String?
            while (bufferedReader.readLine().also { line = it } != null) {
                stringBuilder.append(line)
            }
            bufferedInputStream.close()
            bufferedReader.close()
            httpURLConnect.disconnect()
        }
        return stringBuilder.toString()
    }

    private fun parseJsonToObject(jsonObject: JSONObject?, keyEntity: String): Any? {
        try {
            jsonObject?.let {
                when (keyEntity) {
                    GifEntry.GIF -> return ParseJson().gifParseJson(it)
                    else -> null
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return null
    }

    fun parseJsonToData(jsonObject: JSONObject?, keyEntity: String): Any {
        val data = mutableListOf<Any>()
        try {
            val jsonArray = jsonObject?.getJSONArray(DATA_ENTITY)
            for (i in 0 until (jsonArray?.length() ?: 0)) {
                val jsonObjects = jsonArray?.getJSONObject(i)
                val item = ParseDataWithJson().parseJsonToObject(jsonObjects, keyEntity)
                item?.let { data.add(it) }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return data
    }

    companion object {
        private const val TIME_OUT = 20000
        private const val METHOD_GET = "GET"
        private const val DATA_ENTITY = "data"
    }
}
