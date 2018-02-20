package com.epsilonmoves.instagramlogin.activity.view_model

import android.arch.lifecycle.LiveData

interface InstaViewModelInterface {
    fun setToken(token: String)
    fun requestUserNamePhoto()
    fun getLiveUserName():LiveData<String>
    fun getLiveUserImage():LiveData<String>
}