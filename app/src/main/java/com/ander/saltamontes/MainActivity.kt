package com.ander.saltamontes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.ander.saltamontes.Activities.RegisterActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeComponents()
    }

    private fun initializeComponents() {
        var btnRegister: Button = findViewById(R.id.btnRegistros)
        btnRegister.setOnClickListener{ OnClick(1) };
    }

    private fun OnClick(button:Int) {
        when(button){
            1 -> { startActivity(Intent(this,RegisterActivity::class.java)) }
        }
    }
}