package com.example.supraapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.example.supraapp.R
import com.example.supraapp.databinding.ActivityRegisterBinding
import com.example.supraapp.roomdatabase.model.User
import com.example.supraapp.roomdatabase.viewmodel.DataStoreViewModel
import com.example.supraapp.roomdatabase.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
class Register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    private val dataStoreViewModel: DataStoreViewModel by viewModels()
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        checkIfUserHasSavedDetails()

        makeButtonNotClickableAtFirst()



    }

    private fun checkIfUserHasSavedDetails(){

        dataStoreViewModel.savedKey.observe(this){

            if (it == true){
                //saved go to the next activity
                val intent = Intent(this, UserDetailsActivity::class.java)
                startActivity(intent)
            }

            //user hasn't saved details, show the form
            else{
                initViews()
            }

        }
    }


    private fun initViews(){
        handleClick()
    }

    /**
     * Make button unclickable to avoid empty entries into room
     */

    private fun makeButtonNotClickableAtFirst(){

        //Make button UnClickable for the first time
        binding.buttonRegister.isEnabled = false
        binding.buttonRegister.background = ContextCompat.getDrawable(
            this,
            R.drawable.btn_opaque
        )

        //make the button clickable after detecting changes in input field
        val watcher: TextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                val nameEt = binding.username.text.toString()
                val emailEt = binding.emailRegister.text.toString()
                val passwordEt = binding.passwordRegister.text.toString()

                if (nameEt.isEmpty() || emailEt.isEmpty() || passwordEt.isEmpty()) {
                    binding.buttonRegister.isEnabled = false
                    binding.buttonRegister.background = ContextCompat.getDrawable(
                        this@Register,
                        R.drawable.btn_opaque
                    )
                } else {
                    binding.buttonRegister.isEnabled = true
                    binding.buttonRegister.background = ContextCompat.getDrawable(
                        this@Register,
                        R.drawable.btn_round
                    )
                }
            }

            override fun afterTextChanged(s: Editable) {

            }

        }

        binding.username.addTextChangedListener(watcher)
        binding.emailRegister.addTextChangedListener(watcher)
        binding.passwordRegister.addTextChangedListener(watcher)

    }

    /**
     * Handle click of save button
     */
    private fun handleClick(){

        //on click of button save
        binding.buttonRegister.setOnClickListener {

            //get details entered
            val name = binding.username.text.toString()
            val email = binding.emailRegister.text.toString()
            val password = binding.passwordRegister.text.toString()


            val user = User(id = 1, name = name, email = email, password = password)

            //save the details to room database
            userViewModel.insertUserDetails(user)

            userViewModel.response.observe(this){

                Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()

                //success, save key so on next visit user goes to details screen
                dataStoreViewModel.setSavedKey(true)

                //show toast message
                Toast.makeText(this, applicationContext.getString(R.string.record_saved), Toast.LENGTH_LONG).show()

                //go to next activity
                val intent = Intent(this, UserDetailsActivity::class.java)
                startActivity(intent)

            }

        }

    }
}