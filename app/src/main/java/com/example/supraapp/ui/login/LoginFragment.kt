package com.example.supraapp.ui.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.supraapp.R
import com.example.supraapp.databinding.FragmentLoginBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import kotlin.coroutines.coroutineContext

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LoginViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        init()
        observeData()

        return binding.root
    }

    private fun observeData() {
        with(viewModel) {
            observeIsLogin().observe(requireActivity()){
                Log.d("observe", "observeData: ")
                it.let { data ->
                    if (data != null) {
                        val bundle = Bundle().apply {
                            putString("email", binding.email.text.toString())
                        }
                        if (isAdded) {
                            findNavController().navigate(R.id.action_loginFragment_to_navigationParentFragment3, bundle)
                        }
                    } else {
                        Toast.makeText(requireActivity(), "Email Salah", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    private fun init() {
        with(binding){
            buttonLogin.setOnClickListener {
                if (email.text.isNullOrBlank()){
                    email.error = "Email masih kosong"
                }
                if (password.text.isNullOrBlank()){
                    password.error = "Password masih kosong"
                }
                if (!email.text.isNullOrBlank() && !password.text.isNullOrBlank()){
                    viewModel.getDataLogin(email.text.toString(), password.text.toString())
                }
            }

            buatAkun.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment5)
            }
        }
    }

}