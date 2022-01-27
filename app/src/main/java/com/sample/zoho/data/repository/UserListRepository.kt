package com.sample.zoho.data.repository

import com.sample.zoho.data.responsemodels.UserResponseModel
import com.sample.zoho.data.webservice.UserWebService
import retrofit2.Response
import javax.inject.Inject

class UserListRepository @Inject constructor(var userWebService:UserWebService) {

    suspend fun getData(): Response<UserResponseModel> =
        userWebService.getDataResponse()


}