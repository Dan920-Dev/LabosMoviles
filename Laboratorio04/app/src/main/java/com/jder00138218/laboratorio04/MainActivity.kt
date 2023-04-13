package com.jder00138218.laboratorio04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var saveButton: Button
    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var  errorMessageTextView: TextView

    // Data
    private var name = ""
    private var phone = ""
    private var email = ""
    private var flag  = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()


            saveButton.setOnClickListener {

                if (nameEditText.text.isEmpty() or phoneEditText.text.isEmpty() or emailEditText.text.isEmpty()){
                    errorMessageTextView.text = getString(R.string.campo_vacio)
                    flag = false
                }else{
                    flag = true
                }

                if (flag == true)
                    onSend()
            }


    }

    private  fun bind(){
        saveButton = findViewById(R.id.save_button)
        nameEditText = findViewById(R.id.name_editText)
        phoneEditText = findViewById(R.id.phone_editText)
        emailEditText = findViewById(R.id.email_editText)
        errorMessageTextView = findViewById(R.id.error_message)
    }

    private fun onSend(){

        // Data
        name = nameEditText.text.toString()
        email = emailEditText.text.toString()
        phone = phoneEditText.text.toString()

        // Intent
        val intent = Intent(this, ShareActivity::class.java)
        intent.putExtra(KEY_NAME_USER, name)
        intent.putExtra(KEY_EMAIL_USER, email)
        intent.putExtra(KEY_PHONE_USER, phone)
        startActivity(intent)
    }

    companion object{
        const val KEY_NAME_USER = "Name"
        const val KEY_PHONE_USER = "phone"
        const val KEY_EMAIL_USER = "Email"
    }

}