package com.epsilonmoves.instagramlogin.model

import com.squareup.moshi.Json

data class Counts(@Json(name = "followed_by")
                  val followedBy: Int = 0,
                  @Json(name = "follows")
                  val follows: Int = 0,
                  @Json(name = "media")
                  val media: Int = 0)