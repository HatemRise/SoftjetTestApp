package com.example.softjettest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.softjettest.databinding.MainScreenItemTemplateBinding
import com.example.softjettest.repositories.entities_and_models.User

class MainScreenUsersAdapter(private val listener: OnClick) : ListAdapter<User, MainScreenUsersAdapter.MainScreenUsersViewHolder>(
    UserComparator()
) {
    fun interface OnClick{
        fun onClick(user: User)
    }

    inner class MainScreenUsersViewHolder(private val binding: MainScreenItemTemplateBinding) : RecyclerView.ViewHolder(binding.root){

        init{
            binding.root.setOnClickListener { listener.onClick(getItem(adapterPosition)) }
        }
        fun bind(user: User){
            binding.apply {
                Glide.with(itemView)
                    .load(user.avatar)
                    .into(mainScreenUserAvatar)
                mainScreenUserFirstName.text = user.firstName
                mainScreenUserLastName.text = user.lastName
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MainScreenUsersViewHolder(MainScreenItemTemplateBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))

    override fun onBindViewHolder(holder: MainScreenUsersViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class UserComparator : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: User, newItem: User) =
            oldItem == newItem

    }
}