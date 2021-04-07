@file:Suppress("DEPRECATION")

package com.example.ygifandroid.data.source.remote.fetchjson

import android.os.AsyncTask
import com.example.ygifandroid.data.source.remote.OnFetchDataJsonListener
import org.json.JSONObject

class GetJsonFromUrl<T>(
    private val listener: OnFetchDataJsonListener<T>,
    private val keyEntity: String
) : AsyncTask<String?, Unit, String>() {

    private var exception: Exception? = null

    override fun doInBackground(vararg params: String?): String {
        var data = ""
        try {
            params[0]?.let { data = ParseDataWithJson().getJsonFromUrl(it) }
        } catch (e: Exception) {
            exception = e
        }
        return data
    }

    override fun onPostExecute(result: String) {
        super.onPostExecute(result)
        if (result.isNotBlank()) {
            ParseDataWithJson().parseJsonToData(JSONObject(result), keyEntity).let {
                @Suppress("UNCHECKED_CAST")
                listener.onSuccess(it as T)
            }
        } else {
            listener.onError(exception)
        }
    }
}
