package com.sample.zoho.data.responsemodels

import com.google.gson.annotations.SerializedName

data class UserResponseModel(

    @SerializedName("results" ) var results : MutableList<Results> = mutableListOf()

)

data class Results (

    @SerializedName("gender"     ) var gender     : String?     = null,
    @SerializedName("name"       ) var name       : Name?       = Name(),
    @SerializedName("location"   ) var location   : Location?   = Location(),
    @SerializedName("email"      ) var email      : String?     = null,
    @SerializedName("phone"      ) var phone      : String?     = null,
    @SerializedName("cell"       ) var cell       : String?     = null,
    @SerializedName("picture"    ) var picture    : Picture?    = Picture(),
    @SerializedName("nat"        ) var nat        : String?     = null

)

data class Name (

    @SerializedName("title" ) var title : String? = null,
    @SerializedName("first" ) var first : String? = null,
    @SerializedName("last"  ) var last  : String? = null

)

data class Street (

    @SerializedName("number" ) var number : Double?    = null,
    @SerializedName("name"   ) var name   : String? = null

)

data class Location (

    @SerializedName("street"      ) var street      : Street?      = Street(),
    @SerializedName("city"        ) var city        : String?      = null,
    @SerializedName("state"       ) var state       : String?      = null,
    @SerializedName("country"     ) var country     : String?      = null,
    @SerializedName("postcode"    ) var postcode    : String?         = null,

)

data class Picture (

    @SerializedName("large"     ) var large     : String? = null,
    @SerializedName("medium"    ) var medium    : String? = null,
    @SerializedName("thumbnail" ) var thumbnail : String? = null

)
