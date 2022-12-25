package com.example.sharepreferenceapplication.sharepref



import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import java.lang.reflect.Type


class Sharepreference (
    var _context: Context,

    ) {
    var pref: SharedPreferences
    var editor: SharedPreferences.Editor
    var PRIVATE_MODE = 0
    fun createLoginSession(name: String?, email: String?) {
        editor.putBoolean(IS_LOGIN, true)
        editor.putString(KEY_NAME, name)
        editor.putString(KEY_EMAIL, email)
        editor.commit()
    }

    fun checkLogin(name: String) {
        if (!isLoggedIn) {
            val i = Intent(_context, SingInActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            _context.startActivity(i)
        }
    }

    val userDetails: HashMap<String, String?>
        get() {
            val user = HashMap<String, String?>()
            user[KEY_NAME] =
                pref.getString(KEY_NAME, null)
            user[KEY_EMAIL] =
                pref.getString(KEY_EMAIL, null)
            user[KEY_NAME] = pref.getString(KEY_NAME, null)
            return user
        }

    fun logoutUser() {
        editor.clear()
        editor.commit()
        val i = Intent(_context, SingInActivity::class.java)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        _context.startActivity(i)
    }

    val isLoggedIn: Boolean
        get() = pref.getBoolean(IS_LOGIN, false)

    companion object {
        private const val PREF_NAME = "AndroidHivePref"
        private const val IS_LOGIN = "IsLoggedIn"
        const val KEY_NAME = "name"
        const val KEY_EMAIL = "email"
        const val KEY_LIST = "user_list"
    }

    init {
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }


    fun saveUserList(arrayList: ArrayList<String>) {
        val gson = Gson()
        val json = gson.toJson(arrayList)
        editor.putString(KEY_LIST, json)
        editor.apply()
    }

    fun getUserList() :ArrayList<String>{
        val gson = Gson()
        val json = pref.getString(KEY_LIST, null)
        val type = object : TypeToken<List<String?>?>() {}.type
        return gson.fromJson(json, type)
    }

}




