package com.chhabi.assignment1week5.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chhabi.assignment1week5.R
import com.chhabi.assignment1week5.model.Post
import de.hdodenhof.circleimageview.CircleImageView

class PostAdapter (
    val postDetails: ArrayList<Post>,
    val context: Context
): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgProfile: CircleImageView
        val tvUsername: TextView
        val imgPost: ImageView
        val tvUserCaption: TextView

        init {
            imgProfile = view.findViewById(R.id.imgProfile)
            tvUsername = view.findViewById(R.id.tvUsername)
            imgPost = view.findViewById(R.id.imgPost)
            tvUserCaption = view.findViewById(R.id.tvUserCaption)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postDetails[position]

        Glide.with(context)
            .load(post.profileLink)
            .into(holder.imgProfile)

        holder.tvUsername.text = post.username
        holder.tvUserCaption.text = "${post.username} / ${post.caption}"

        Glide.with(context)
            .load(post.postImageLink)
            .into(holder.imgPost)
    }

    override fun getItemCount(): Int {
        return postDetails.size
    }
}

