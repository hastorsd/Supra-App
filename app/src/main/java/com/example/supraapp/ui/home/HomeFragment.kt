package com.example.supraapp.ui.home

import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.supraapp.R
import com.example.supraapp.databinding.FragmentHomeBinding
import com.example.supraapp.registdata.remote.response.NewSurahResponse
import com.example.supraapp.registdata.remote.response.NewSurahResponseItem
import com.example.supraapp.registdata.remote.response.SurahResponse
import org.koin.android.ext.android.inject

class HomeFragment : Fragment(), HomeAdapter.onItemClick {

    private lateinit var _binding: FragmentHomeBinding
    private val binding get() = _binding
    private val viewModel: HomeViewModel by inject()
    private var list: List<NewSurahResponseItem> = listOf()
    lateinit var mediaPlayer: MediaPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        init()
        observeData()
        return binding.root
    }

    private fun observeData() {
        with(viewModel){
            observeSurah.observe(requireActivity()){
                it.let { data ->
                    list = data.body() ?: listOf()
                    with(binding.surahs){
                        adapter = HomeAdapter(list, this@HomeFragment)
                        layoutManager = LinearLayoutManager(requireContext())
                    }
                }
            }
        }
    }

    private fun init() {
        viewModel.getSurah()
    }

    override fun setOnItemClick(data: NewSurahResponseItem, position: Int) {
        mediaPlayer = MediaPlayer()
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)

        // on below line we are running a try
        // and catch block for our media player.
        try {
            // on below line we are setting audio
            // source as audio url on below line.
            mediaPlayer.setDataSource(data.audio)

            // on below line we are
            // preparing our media player.
            mediaPlayer.prepare()

            // on below line we are
            // starting our media player.
            mediaPlayer.start()

        } catch (e: Exception) {

            // on below line we are handling our exception.
            e.printStackTrace()
        }
        // on below line we are displaying a toast message as audio player.
        Toast.makeText(requireContext(), "Audio started playing..", Toast.LENGTH_SHORT).show()

    }

}