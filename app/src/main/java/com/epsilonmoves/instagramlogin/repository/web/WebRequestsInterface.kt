package com.epsilonmoves.instagramlogin.repository.web

import android.arch.lifecycle.MutableLiveData

interface WebRequestsInterface {
    fun requestUserNamePhoto(accessToken: String?, liveUserName: MutableLiveData<String>, liveUserPictureUrl: MutableLiveData<String>)
}