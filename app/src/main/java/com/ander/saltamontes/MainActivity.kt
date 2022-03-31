package com.ander.saltamontes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.ander.saltamontes.Activities.RegisterActivity
import com.ander.saltamontes.Activities.StatisticsActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeComponents()
    }

    private fun initializeComponents() {
        var btnRegister: Button = findViewById(R.id.btnRegistros)
        var btnInformation: Button = findViewById(R.id.btnInformación);
        btnRegister.setOnClickListener{ OnClick(1) };
        btnInformation.setOnClickListener { OnClick(2) };
    }

    private fun OnClick(button:Int) {
        when(button){
            1 -> { startActivity(Intent(this,RegisterActivity::class.java)) }
            2 -> { startActivity(Intent(this, StatisticsActivity::class.java)) }
        }
    }
}