package com.epsilonmoves.instagramlogin.repository

import android.arch.lifecycle.MutableLiveData

interface RepositoryInterface {
    fun requestUserNamePhoto(value: String?, liveUserName: MutableLiveData<String>, liveUserPictureUrl: MutableLiveData<String>)
}