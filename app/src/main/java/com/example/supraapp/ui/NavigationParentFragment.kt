package com.example.supraapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.supraapp.R
import com.example.supraapp.databinding.FragmentNavigationParentBinding
import com.example.supraapp.ui.home.HomeFragment
import com.example.supraapp.ui.profile.ProfileFragment

class NavigationParentFragment : Fragment() {

    private var _binding: FragmentNavigationParentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNavigationParentBinding.inflate(inflater, container, false)
        val email = arguments?.getString("email") ?: ""

        val homeFragment = HomeFragment()
        val profileFragment = ProfileFragment().apply{
            arguments = Bundle().apply {
                putString("email", email)
            }
        }

        setCurrentFragment(homeFragment)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.nav_home -> setCurrentFragment(homeFragment)
                R.id.nav_profile -> setCurrentFragment(profileFragment)
            }
            true
        }

        return binding.root
    }

    private fun setCurrentFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction().apply {
            replace(R.id.parent_fragment, fragment)
            commit()
        }
    }
}