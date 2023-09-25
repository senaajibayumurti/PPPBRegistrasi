package com.example.pppbregistrasi

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
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

        val fullText = "Already have an account? Log in."
        val spannableString = SpannableString(fullText)
        val colorSpan = ForegroundColorSpan(Color.CYAN)
        val underlineSpan = UnderlineSpan()
        val startIndex = fullText.indexOf("Log in")
        val endIndex = startIndex + "Log in".length
        spannableString.setSpan(colorSpan, startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(underlineSpan, startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding.haveAnAccount.text = spannableString

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