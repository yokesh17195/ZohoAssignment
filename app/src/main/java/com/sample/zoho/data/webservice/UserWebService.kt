package com.sample.zoho.data.webservice

import com.sample.zoho.data.responsemodels.UserResponseModel
import retrofit2.Response
import retrofit2.http.GET

/**
 * @author Yokesh.K.P
 * */

interface UserWebService {

    @GET("api/?results=25")
    suspend fun getDataResponse(): UserResponseModel

}