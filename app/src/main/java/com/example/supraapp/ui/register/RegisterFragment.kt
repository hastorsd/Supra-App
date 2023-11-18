package com.example.supraapp.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.supraapp.R
import com.example.supraapp.databinding.FragmentRegisterBinding
import com.example.supraapp.registdata.local.entity.UserEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RegisterViewModel by inject()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        init()
        observeData()
        return binding.root
    }

    private fun observeData() {
        with(viewModel) {
            observeIsRegister().observe(viewLifecycleOwner) {
                it.let { data ->
                    if (data){
                        findNavController().navigate(R.id.action_registerFragment5_to_loginFragment)
                    } else {
                        Toast.makeText(requireContext(), "Email sudah terdaftar", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
    private fun init() {

        binding.buttonRegister.setOnClickListener {
            val name = binding.username.text.toString()
            val email = binding.emailRegister.text.toString()
            val password = binding.passwordRegister.text.toString()
            val user = UserEntity(0, name, email, password)
            viewModel.insertUser(user)
        }
    }
}