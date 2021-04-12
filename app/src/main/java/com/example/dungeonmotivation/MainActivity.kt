package com.example.dungeonmotivation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    var login = "123"
    var pass = "228"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener{
            if(findViewById<EditText>(R.id.editTextTextPersonName).text.toString() == login &&
                findViewById<EditText>(R.id.editTextTextPassword).text.toString() == pass){
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            }
            else{
                findViewById<EditText>(R.id.editTextTextPersonName).error = "ошибка стоп"
            }
        }
    }
}