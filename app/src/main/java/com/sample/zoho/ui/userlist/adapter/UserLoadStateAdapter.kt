package com.sample.zoho.ui.userlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sample.zoho.databinding.UserListLoaderBinding

class UserLoadStateAdapter(private val retry:()->Unit) : LoadStateAdapter<UserLoadStateAdapter.UserLoadStateViewHolder>() {

    inner class UserLoadStateViewHolder(private val binding: UserListLoaderBinding) :
        RecyclerView.ViewHolder(binding.root) {

            init {

                binding.retry.setOnClickListener {
                    retry.invoke()
                }

            }

            fun bind(loadState: LoadState){
                binding.apply {
                    progressBar.isVisible = loadState is LoadState.Loading
                    retry.isVisible = loadState !is LoadState.Loading
                    errorLabel.isVisible = loadState !is LoadState.Loading
                }
            }

    }

    override fun onBindViewHolder(holder: UserLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): UserLoadStateViewHolder {
        return UserLoadStateViewHolder(
            UserListLoaderBinding.inflate(LayoutInflater.from(parent.context),parent,
                false)
        )
    }

}