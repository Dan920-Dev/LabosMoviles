package com.jder00138218.laboratorio04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ShareActivity : AppCompatActivity() {

    // Data
    private var name = ""
    private var phone = 0
    private var email = ""

    // Views
    private lateinit var shareButton: Button
    private lateinit var nameTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var phoneTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        bind()

        intent?.let { intent ->
            name = (intent.getStringExtra(MainActivity.KEY_NAME_USER)).toString()
            email = (intent.getStringExtra(MainActivity.KEY_EMAIL_USER)).toString()
            phone = intent.getIntExtra(MainActivity.KEY_PHONE_USER, 0)
        }

        information(name, email, phone)

        shareButton.setOnClickListener {
            share(name, email, phone)
        }

    }

    private fun bind(){
        shareButton = findViewById(R.id.share_button)
        nameTextView = findViewById(R.id.name_share__textView)
        phoneTextView = findViewById(R.id.phone_share_textView)
        emailTextView = findViewById(R.id.email_share_textView)
    }

   private  fun information(name: String, email: String, phone: Int){
        nameTextView.text = name
        phoneTextView.text = phone.toString()
        emailTextView.text = email
    }

    private fun share(name: String, email: String, phone: Int){
        val information = getString(R.string.name) + ": ${name}\n"  +
                          getString(R.string.phone_number) + ": ${phone}\n" +
                          getString(R.string.email) + ": ${email}"

        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, information)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)


    }


}