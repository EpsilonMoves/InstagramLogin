package com.epsilonmoves.instagramlogin.utils

const val INSTA_LOGIN_URL = "https://www.instagram.com/oauth/authorize/?client_id=\tf33134aace3f4e28bdb9325e794788d9&redirect_uri=http://yourcallback.com/&response_type=token"
const val ACCESS_TOKEN  = "#access_token="
const val ACCESS_TOKEN_REQUEST_URL  = "https://api.instagram.com/v1/users/self/?access_token="
const val REDIRECT_PREFIX= "http://yourcallback.com/"