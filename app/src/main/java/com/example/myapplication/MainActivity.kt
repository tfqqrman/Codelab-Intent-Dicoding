package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pindahActivity: Button = findViewById(R.id.btn_move_activity)
        pindahActivity.setOnClickListener(this)

        val pindahActivityData: Button = findViewById(R.id.btn_move_activity_data)
        pindahActivityData.setOnClickListener(this)

        val pindahImplicit: Button = findViewById(R.id.btn_move_implicit_dial)
        pindahImplicit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_move_activity ->{
                val pindahIntent = Intent(this@MainActivity,ActivityPindah::class.java)
                startActivity(pindahIntent)
            }
            R.id.btn_move_activity_data->{
                val pindahIntentData = Intent(this@MainActivity,PindahDenganData::class.java)
                pindahIntentData.putExtra(PindahDenganData.EXTRA_NAME,"Januar")
                pindahIntentData.putExtra(PindahDenganData.EXTRA_AGE,90)
                startActivity(pindahIntentData)
            }
            R.id.btn_move_implicit_dial ->{
                val phoneNumber = "085330028231"
                val pindahImplicit = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(pindahImplicit)
            }
        }
    }
}