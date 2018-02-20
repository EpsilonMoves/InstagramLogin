package com.epsilonmoves.instagramlogin.model

import com.squareup.moshi.Json

data class Meta(@Json(name = "code")
                val code: Int = 0)