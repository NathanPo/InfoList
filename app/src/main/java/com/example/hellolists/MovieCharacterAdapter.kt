package com.example.hellolists

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieCharacterAdapter(val data : MutableList<MovieCharacter>, val context: Activity, val onItemClickLister : View.OnClickListener): RecyclerView.Adapter<MovieCharacterAdapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val firstnameTextView : TextView = itemView.findViewById(R.id.row_character_text_firstname)
        val lastnameTextView : TextView = itemView.findViewById(R.id.row_character_text_secondname)
        val movieTextView : TextView = itemView.findViewById(R.id.row_character_text_movie)
        val alignementImage : ImageView = itemView.findViewById(R.id.row_character_image_alignement)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rowView : View = LayoutInflater.from(context).inflate(R.layout.row_character, parent, false)
        rowView.setOnClickListener(onItemClickLister)
        return ViewHolder(rowView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.firstnameTextView.text = data[position].firstname
        holder.lastnameTextView.text = data[position].secondName
        holder.movieTextView.text = data[position].movie
        if (data[position].good_guy) {
            holder.alignementImage.setImageResource(android.R.drawable.arrow_up_float)
        } else {
            holder.alignementImage.setImageResource(android.R.drawable.arrow_down_float)
        }
        holder.itemView.tag = position
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun newData(newData : List<MovieCharacter>) {
        data.clear()
        data.addAll(newData)
        this.notifyDataSetChanged()
    }
}