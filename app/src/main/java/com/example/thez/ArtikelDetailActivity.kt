package com.example.thez

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class ArtikelDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artikel_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val dataArtikel = intent.getParcelableArrayExtra("Artikel") as Artikel

        val name = findViewById<TextView>(R.id.tv_item_name)
        val description = findViewById<TextView>(R.id.tv_item_description)
        val photo = findViewById<ImageView>(R.id.img_item_photo)
        val date = findViewById<TextView>(R.id.tv_item_date)

        photo.setImageResource(dataArtikel.photo)
        name.text = dataArtikel.name
        description.text = dataArtikel.description
        date.text = "Terbit  ${dataArtikel.date}"
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}