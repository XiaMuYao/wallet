package com.xiamuyao.ulanbator.util

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlin.reflect.KClass


object JSONUtils {


    fun <T : Any> parseJsonToObj(jsonString: String, classOfT: KClass<T>): T {
        return Gson().fromJson(jsonString, classOfT.java)
    }


    fun <T> parseJsonToListOrMap(jsonString: String): T {
        val jsonType = object : TypeToken<T>() {}.type
        return Gson().fromJson(jsonString, jsonType)
    }


    fun toJson(obj: Any, pretty: Boolean = false): String {
        if (pretty) {
            return GsonBuilder().setPrettyPrinting().create().toJson(obj)
        }
        return Gson().toJson(obj)
    }

}