package com.wingsmight.boilerplate.data.store

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.gson.Gson
import com.wingsmight.boilerplate.data.model.auth.User
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserStore @Inject constructor(@ApplicationContext private val context: Context) {
    private val gson: Gson = Gson()

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("UserStore")
        private val KEY = stringPreferencesKey("user")
    }

    suspend fun save(user: User) {
        context.dataStore.edit { preferences ->
            preferences[KEY] = gson.toJson(user, User::class.java)
        }
    }

    fun load(): Flow<User?> =
        context.dataStore.data.map { preferences ->
            val jsonString = preferences[KEY] ?: ""
            gson.fromJson(jsonString, User::class.java)
        }

    fun isEmpty(): Flow<Boolean> =
        context.dataStore.data.map { preference ->
            preference.contains(KEY)
        }

    suspend fun clear() {
        context.dataStore.edit {
            it.remove(KEY)
        }
    }
}
