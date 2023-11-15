package com.example.userslist_hw8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(
    private val users: List<User>
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    interface OnDeleteClickListener {
        fun onDeleteClick(user: User)
    }

    interface OnEditClickListener {
        fun onEditClick(user: User)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.tvFirstName.text = user.firstName
        holder.tvLastName.text = user.lastName
        holder.tvEmail.text = user.email
        holder.btnDelete.setOnClickListener {
            onDeleteClickListener.onDeleteClick(user)
        }
        holder.btnEdit.setOnClickListener {
            onEditClickListener.onEditClick(user)
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }


    inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvFirstName: TextView = view.findViewById(R.id.tvFirstName)
        val tvLastName: TextView = view.findViewById(R.id.tvLastName)
        val tvEmail: TextView = view.findViewById(R.id.tvEmail)
        val btnDelete: Button = view.findViewById(R.id.btnDelete)
        val btnEdit: Button = view.findViewById(R.id.btnEdit)
    }
}
