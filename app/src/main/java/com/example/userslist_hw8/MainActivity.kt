package com.example.userslist_hw8

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.userslist_hw8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), UserAdapter.OnDeleteClickListener,
    UserAdapter.OnEditClickListener {
    companion object {
        const val REQUEST_CODE = 1
    }

    private val users = mutableListOf<User>()

    private val userAdapter = UserAdapter(users)

    private lateinit var binding: ActivityMainBinding

    private val ADD_USER_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rvUsers: RecyclerView = binding.rvUsers

        rvUsers.layoutManager = LinearLayoutManager(this)

        rvUsers.adapter = userAdapter

        binding.btnAddUser.setOnClickListener {
            startActivityForResult(Intent(this, UserActivity::class.java), ADD_USER_REQUEST_CODE)
        }
    }

    override fun onDeleteClick(user: User) {
        users.remove(user)
        userAdapter.notifyDataSetChanged()
    }

    override fun onEditClick(user: User) {
        val intent = Intent(this, UserActivity::class.java)
        intent.putExtra("user", user)
        registerForActivityResult(ActivityResultContracts.StartActivityForResult) {

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    }
}