package com.example.supraapp.ui.home

import android.media.AudioAttributes
import android.media.MediaActionSound
import android.provider.MediaStore.Audio
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.supraapp.R
import com.example.supraapp.registdata.remote.response.NewSurahResponse
import com.example.supraapp.registdata.remote.response.NewSurahResponseItem
import com.example.supraapp.registdata.remote.response.SurahResponse
import java.util.Collections.list

class HomeAdapter(private val list: List<NewSurahResponseItem>, private var playListener: onItemClick): RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {
    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val title: TextView = view.findViewById(R.id.title)
        val arabic: TextView = view.findViewById(R.id.titlearabic)
        val place: TextView = view.findViewById(R.id.tempatTurun)
        val arti: TextView = view.findViewById(R.id.artiSurah)
        val description: TextView = view.findViewById(R.id.deskripsiSurah)
        val audio: Button = view.findViewById(R.id.buttonAudio)
        fun itemClick(data: NewSurahResponseItem, action: onItemClick){
            audio.setOnClickListener {
                action.setOnItemClick(data, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.surah_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = list[position].namaLatin
        holder.arabic.text = list[position].nama
        holder.place.text = list[position].tempatTurun
        holder.arti.text = list[position].arti
        holder.description.text = list[position].deskripsi
        holder.itemClick(list[position], playListener)
    }

    interface onItemClick {
        fun setOnItemClick(data: NewSurahResponseItem, position: Int)
    }


}