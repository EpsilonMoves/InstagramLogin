package com.epsilonmoves.instagramlogin.activity.view_model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.epsilonmoves.instagramlogin.repository.Repository
import com.epsilonmoves.instagramlogin.repository.RepositoryInterface


class InstaViewModel: ViewModel(),InstaViewModelInterface {

    val repository: RepositoryInterface = Repository()

    private var liveToken = MutableLiveData<String>()
    private var liveUserName = MutableLiveData<String>()
    private var liveUserPictureUrl = MutableLiveData<String>()

    override fun setToken(token: String) { liveToken.value = token }

    override fun getLiveUserName(): LiveData<String> = liveUserName

    override fun getLiveUserImage(): LiveData<String> = liveUserPictureUrl

    override fun requestUserNamePhoto() { repository.requestUserNamePhoto(liveToken.value,liveUserName,liveUserPictureUrl) }


}