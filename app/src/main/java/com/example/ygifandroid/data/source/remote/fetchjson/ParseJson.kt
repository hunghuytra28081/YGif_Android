package com.example.ygifandroid.data.source.remote.fetchjson

import com.example.ygifandroid.data.model.Gif
import com.example.ygifandroid.data.model.GifEntry
import com.example.ygifandroid.data.model.User
import com.example.ygifandroid.data.model.UserEntity
import org.json.JSONObject

class ParseJson {

    fun gifParseJson(jsonObject: JSONObject): Gif {
        return Gif(
            id = jsonObject.getString(GifEntry.ID),
            imageUrl = jsonObject.getJSONObject(GifEntry.IMAGE)
                .getJSONObject(GifEntry.FIXED_WIDTH)
                .getString(GifEntry.URL),
            title = jsonObject.getString(GifEntry.TITLE),
            dateTime = jsonObject.getString(GifEntry.DATE_TIME),
            user = userParseJson(jsonObject)
        )
    }

    private fun userParseJson(jsonObject: JSONObject): User {
        var user = User()
        if (jsonObject.has(UserEntity.USER)) {
            val jsonUser = jsonObject.getJSONObject(UserEntity.USER)
            user = User(
                name = jsonUser.getString(UserEntity.USERNAME),
                avatarUrl = jsonUser.getString(UserEntity.AVATAR_URL)
            )
        }
        return user
    }
}
