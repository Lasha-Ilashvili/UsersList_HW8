package com.example.userslist_hw8

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.userslist_hw8.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        user = intent.getParcelableExtra("user") ?: User(0, "", "", "")

        binding.etFirstName.setText(user.firstName)
        binding.etLastName.setText(user.lastName)
        binding.etEmail.setText(user.email)

        binding.btnSave.setOnClickListener {
            val firstName = binding.etFirstName.text.toString()
            val lastName = binding.etLastName.text.toString()
            val email = binding.etEmail.text.toString()
            val updatedUser = user.copy(firstName = firstName, lastName = lastName, email = email)
            val resultIntent = Intent()
            resultIntent.putExtra("updatedUser", updatedUser)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}