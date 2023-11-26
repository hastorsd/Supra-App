package com.example.supraapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.supraapp.R
import com.example.supraapp.databinding.FragmentHomeBinding
import com.example.supraapp.registdata.remote.response.SurahResponse
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {

    private lateinit var _binding: FragmentHomeBinding
    private val binding get() = _binding
    private val viewModel: HomeViewModel by inject()
    private var list: List<SurahResponse> = listOf()

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
                    list = data.body()?.SurahResponse ?: listOf()
                    with(binding.surahs){
                        adapter = HomeAdapter(list)
                        layoutManager = LinearLayoutManager(requireContext())
                    }
                }
            }
        }
    }

    private fun init() {
        viewModel.getSurah()
    }

}