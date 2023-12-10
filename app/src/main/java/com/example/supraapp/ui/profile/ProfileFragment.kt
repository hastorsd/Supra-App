package com.example.supraapp.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.supraapp.R
import com.example.supraapp.databinding.FragmentProfileBinding
import org.koin.android.ext.android.inject

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ProfileViewModel by inject()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root
        val email = arguments?.getString("email") ?: ""

        readData(email)

        return view
    }

    private fun readData(email: String) {
        viewModel.getDataProfile(email)
        displayData()
    }

    private fun displayData(){
        with(viewModel){
            observeProfile().observe(viewLifecycleOwner){
                it.let { data ->
                    binding.tvUsername.text = data.nama
                    binding.tvEmail.text = data.email
                }
            }
        }
    }

}