package com.example.pppbregistrasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pppbregistrasi.MainActivity.Companion.CREDENTIALS_USERNAME
import com.example.pppbregistrasi.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            val username = intent.getStringExtra(CREDENTIALS_USERNAME)

            usernameTextView.text = "Welcome ${username}."

            buttonLogout.setOnClickListener{
                startActivity(Intent(this@SecondActivity, MainActivity::class.java))
            }
        }
    }
}