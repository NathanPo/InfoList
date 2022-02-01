package com.example.hellolists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = ArrayList<MovieCharacter>()
        data.add(MovieCharacter("Han", "Solo", "Star Wars", true))
        data.add(MovieCharacter("Tom","Riddle","Harry Potter", false))
        data.add(MovieCharacter("Han", "Solo", "Star Wars", true))
        data.add(MovieCharacter("Tom","Riddle","Harry Potter", false))
        data.add(MovieCharacter("Han", "Solo", "Star Wars", true))
        data.add(MovieCharacter("Tom","Riddle","Harry Potter", false))
        data.add(MovieCharacter("Han", "Solo", "Star Wars", true))
        data.add(MovieCharacter("Tom","Riddle","Harry Potter", false))
        data.add(MovieCharacter("Han", "Solo", "Star Wars", true))
        data.add(MovieCharacter("Tom","Riddle","Harry Potter", false))

        val movieCharacterRecyclerView : RecyclerView = findViewById(R.id.activity_main_list)
        movieCharacterRecyclerView.layoutManager = LinearLayoutManager(this)
        movieCharacterRecyclerView.setHasFixedSize(true)
        val onItemClickListener : View.OnClickListener = object : View.OnClickListener {
            override fun onClick(clickedRowView: View?) {
                val position : Int = clickedRowView!!.tag as Int
                Toast.makeText(this@MainActivity, data[position].firstname, Toast.LENGTH_SHORT).show()
            }
        }
        movieCharacterRecyclerView.adapter = MovieCharacterAdapter(data, this, onItemClickListener)
        movieCharacterRecyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
    }
}