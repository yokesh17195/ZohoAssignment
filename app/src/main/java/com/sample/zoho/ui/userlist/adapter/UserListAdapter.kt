package com.sample.zoho.ui.userlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.sample.zoho.data.models.UserListModel
import com.sample.zoho.data.responsemodels.Results
import com.sample.zoho.databinding.ItemUserListBinding
import com.sample.zoho.ui.userlist.diffutils.UserListDiffUtils

class UserListAdapter :
    PagingDataAdapter<Results, UserListAdapter.UserListViewHolder>(UserListDiffUtils()) {

    inner class UserListViewHolder(var binding: ItemUserListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Results) {
            Glide.with(binding.userImg).load(data.picture?.large).circleCrop().centerCrop()
                .diskCacheStrategy(
                    DiskCacheStrategy.ALL
                ).into(binding.userImg)
            binding.userName.text = data.name?.first+" "+data.name?.last
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        return UserListViewHolder(
            ItemUserListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

}