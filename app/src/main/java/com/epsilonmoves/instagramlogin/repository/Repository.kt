package com.epsilonmoves.instagramlogin.repository

import android.arch.lifecycle.MutableLiveData
import com.epsilonmoves.instagramlogin.repository.web.WebRequests
import com.epsilonmoves.instagramlogin.repository.web.WebRequestsInterface

class Repository:RepositoryInterface  {

    val webRequest:WebRequestsInterface = WebRequests()

    override fun requestUserNamePhoto(value: String?, liveUserName: MutableLiveData<String>, liveUserPictureUrl: MutableLiveData<String>) {
        webRequest.requestUserNamePhoto(value,liveUserName,liveUserPictureUrl)
    }

}