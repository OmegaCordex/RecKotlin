package com.example.reckotlin

import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.net.Uri
import android.os.Bundle

class Main2Activity : AppCompatActivity() {

    internal var yourarray: Array<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val uri = StringBuilder("sms:")
        for (i in yourarray!!.indices) {
            uri.append(yourarray!![i])
            uri.append(", ")
        }
        val smsIntent = Intent(Intent.ACTION_VIEW)
        smsIntent.type = "vnd.android-dir/mms-sms"
        smsIntent.data = Uri.parse(uri.toString())
        smsIntent.putExtra("sms_body", "Body of Message")
        startActivity(smsIntent)

    }
}
