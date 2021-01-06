package com.chhabi.assignment1week5.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chhabi.assignment1week5.R
import com.chhabi.assignment1week5.model.User
import de.hdodenhof.circleimageview.CircleImageView

class UserAdapter (
    val lstUser: ArrayList<User>,
    val context: Context,
    val viewTypeId: Int
)
    : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgProfile: CircleImageView
        val tvUsername: TextView

        init {
            imgProfile = view.findViewById(R.id.imgProfile)
            tvUsername = view.findViewById(R.id.tvUsername)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return when (viewTypeId) {
            1 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.userlist_layout, parent, false)
                UserViewHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.story_layout, parent, false)
                UserViewHolder(view)
            }
        }

    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = lstUser[position]
        holder.tvUsername.text = user.username
        Glide.with(context)
            .load(user.profileLink)
            .into(holder.imgProfile)
    }

    override fun getItemCount(): Int {
        return lstUser.size
    }
}

