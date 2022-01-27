package com.sample.zoho.ui.userlist.logic

import com.sample.zoho.data.models.UserListModel
import com.sample.zoho.data.responsemodels.Results
import java.lang.StringBuilder

class UserListLogic {


    fun getUserList(list: MutableList<Results>): MutableList<UserListModel> {

        val userlist: MutableList<UserListModel> = mutableListOf()

        list.forEach {


            val nameBuilder = StringBuilder()
            val name = nameBuilder.apply {
                append(it.name?.title)
                append(".")
                append(it.name?.first)
                append(" ")
                append(it.name?.last)

            }.toString()
            val imgUrl = it.picture?.medium.toString()

            val locationBuilder = StringBuilder()
            val location = locationBuilder.apply {
                append(it.location?.street?.number)
                append(",")
                append(it.location?.street?.name)
                append(",")
                append(it.location?.city)
                append(",")
                append(it.location?.state)
                append(",")
                append(it.location?.country)
                append(",")
            }.toString()

            val dataItem = UserListModel(name, location, imgUrl)

            userlist.add(dataItem)
        }

        return userlist
    }

}