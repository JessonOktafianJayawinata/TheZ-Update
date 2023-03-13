package com.example.thez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvArtikel: RecyclerView
    private val list = ArrayList<Artikel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvArtikel = findViewById(R.id.rv_artikel)
        rvArtikel.setHasFixedSize(true)

        list.addAll(getListArtikel())
        showRecyclerList()
    }

    private fun getListArtikel(): ArrayList<Artikel>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataDate = resources.getStringArray(R.array.data_date)
        val  listArtikel = ArrayList<Artikel>()
        for (i in dataName.indices){
            val artikel = Artikel(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataDate[i])
            listArtikel.add(artikel)
        }
        return listArtikel
    }

    private fun showRecyclerList(){
        rvArtikel.layoutManager = LinearLayoutManager(this)
        val listArtikelAdapter = ListArtikelAdapter(list)
        rvArtikel.adapter = listArtikelAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu_profile, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.profil -> {
                val moveIntent = Intent (this@MainActivity, Profile::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)

    }

}