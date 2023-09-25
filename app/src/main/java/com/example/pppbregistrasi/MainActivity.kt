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
                val allFilled =
                            usernameTxt.text.isNotEmpty()   &&
                            emailTxt.text.isNotEmpty()      &&
                            phoneTxt.text.isNotEmpty()      &&
                            passwordTxt.text.isNotEmpty()
                if (allFilled){
                    if (tncCheckbox.isChecked){
                        buttonRegister.isEnabled = true
                        buttonRegister.alpha = 1.0f

                        val username = usernameTxt.text.toString()

                        val intentToSecondActivity =
                            Intent(this@MainActivity, SecondActivity::class.java)
                        intentToSecondActivity.putExtra(CREDENTIALS_USERNAME, username)
                        startActivity(intentToSecondActivity)
                    }
                    else{
                        buttonRegister.isEnabled = false
                        buttonRegister.alpha = 0.5f
                        val warningTNC = "Please accept the Terms and Conditions."
                        Toast.makeText(this@MainActivity, warningTNC, Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    buttonRegister.isEnabled = false
                    buttonRegister.alpha = 0.5f
                    val warningCredentials = "Please fill out the credentials."
                    Toast.makeText(this@MainActivity, warningCredentials, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}