package com.muhammaddevin.android.sharepreference

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.muhammaddevin.android.sharepreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    val PREFS_NAME = "belajarsharedpreference"
    val KEY_EMAIL = "key.email"
    val KEY_PASSWORD = "key.password"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        getEmail()
    }

    fun getEmail(){
        val email = sharedPreferences.getString(KEY_EMAIL, null)
        binding.textViewEmail.text = email
    }

    fun onLogout(view:View){
        clearData()
        startActivity(Intent(applicationContext, LoginActivity::class.java))
        finish()
    }

    private fun clearData(){
        val editor : SharedPreferences.Editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }
}