package com.xiamuyao.ulanbator.utlis

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlin.reflect.KClass

object JSONUtils {

    fun <T : Any> parseJsonToObj(jsonString: String, classOfT: KClass<T>): T {
        return Gson().fromJson(jsonString, classOfT.java)
    }

    fun toJson(obj: Any, pretty: Boolean = false): String {
        if (pretty) {
            return GsonBuilder().setPrettyPrinting().create().toJson(obj)
        }
        return Gson().toJson(obj)
    }

}