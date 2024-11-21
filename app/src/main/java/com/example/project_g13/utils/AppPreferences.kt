package com.example.project_g13.utils

import android.content.Context

object AppPreferences {
    const val PREFS_NAME = "app_prefs"
    const val KEY_USER_NAME = "user_name"
    const val KEY_COMPLETED_LESSONS = "completed_lessons"

    fun saveString(context: Context, key: String, value: String) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putString(key, value).apply()
    }

    fun getString(context: Context, key: String): String? {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getString(key, null)
    }

    fun saveBooleanList(context: Context, key: String, values: List<Boolean>) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val serialized = values.joinToString(",") { it.toString() }
        prefs.edit().putString(key, serialized).apply()
    }

    fun getBooleanList(context: Context, key: String, size: Int): MutableList<Boolean> {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val serialized = prefs.getString(key, null) ?: return MutableList(size) { false }
        return serialized.split(",").map { it.toBoolean() }.toMutableList()
    }
}
