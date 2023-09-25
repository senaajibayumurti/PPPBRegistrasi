package com.example.pppbregistrasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pppbregistrasi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    companion object{
        const val CREDENTIALS_USERNAME = "credentials_username"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            buttonRegister.setOnClickListener {
                if (usernameTxt.text.isEmpty()   ||
                    emailTxt.text.isEmpty()      ||
                    phoneTxt.text.isEmpty()      ||
                    passwordTxt.text.isEmpty()
                    ){
                    val warningCredentials = "Please fill out the credentials."
                    Toast.makeText(this@MainActivity, warningCredentials, Toast.LENGTH_SHORT).show()
                }
                else{
                    if (tncCheckbox.isChecked){
                        val username = usernameTxt.text.toString()

                        val intentToSecondActivity =
                            Intent(this@MainActivity, SecondActivity::class.java)
                        intentToSecondActivity.putExtra(CREDENTIALS_USERNAME, username)
                        startActivity(intentToSecondActivity)
                    }
                    else{
                        val warningTNC = "Please accept the Terms and Conditions."
                        Toast.makeText(this@MainActivity, warningTNC, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}