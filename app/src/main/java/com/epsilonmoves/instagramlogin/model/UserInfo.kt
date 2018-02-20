package com.epsilonmoves.instagramlogin.model

import com.squareup.moshi.Json

data class UserInfo(@Json(name = "data")
                    val data: Data,
                    @Json(name = "meta")
                    val meta: Meta)