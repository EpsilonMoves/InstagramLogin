package com.epsilonmoves.instagramlogin.model

import com.squareup.moshi.Json

data class Data(@Json(name = "is_business")
                val isBusiness: Boolean = false,
                @Json(name = "website")
                val website: String = "",
                @Json(name = "full_name")
                val fullName: String = "",
                @Json(name = "counts")
                val counts: Counts= Counts(),
                @Json(name = "bio")
                val bio: String = "",
                @Json(name = "profile_picture")
                val profile_picture: String = "",
                @Json(name = "id")
                val id: String = "",
                @Json(name = "username")
                val username: String = "")