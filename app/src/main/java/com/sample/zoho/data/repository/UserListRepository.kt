package com.sample.zoho.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.sample.zoho.data.paging.UserPagingSource
import com.sample.zoho.data.responsemodels.UserResponseModel
import com.sample.zoho.data.webservice.UserWebService
import retrofit2.Response
import javax.inject.Inject

class UserListRepository @Inject constructor(var userWebService:UserWebService) {

    fun getData() = Pager(
        config = PagingConfig(
            pageSize = 25,
            maxSize = 100,
            enablePlaceholders = false
        ),pagingSourceFactory = {UserPagingSource(userWebService)}
    ).liveData

}