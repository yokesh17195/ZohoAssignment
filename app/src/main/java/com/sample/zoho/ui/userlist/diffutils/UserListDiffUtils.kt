package com.sample.zoho.ui.userlist.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.sample.zoho.data.models.UserListModel
import com.sample.zoho.data.responsemodels.Results

class UserListDiffUtils: DiffUtil.ItemCallback<Results>() {
    override fun areItemsTheSame(oldItem: Results, newItem: Results): Boolean {
        return oldItem.login?.id == newItem.login?.id
    }

    override fun areContentsTheSame(oldItem: Results, newItem: Results): Boolean {
        return oldItem == newItem
    }
}