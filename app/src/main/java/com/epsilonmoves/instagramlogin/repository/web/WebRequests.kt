package com.epsilonmoves.instagramlogin.repository.web

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.epsilonmoves.instagramlogin.model.Data
import com.epsilonmoves.instagramlogin.model.UserInfo
import com.epsilonmoves.instagramlogin.utils.ACCESS_TOKEN_REQUEST_URL
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class WebRequests:WebRequestsInterface {
    override fun requestUserNamePhoto(accessToken: String?, liveUserName: MutableLiveData<String>, liveUserPictureUrl: MutableLiveData<String>) {

        // build the retrofit interface with the base url coupled with the access token
        val retrofitInterface = Retrofit.Builder()
                .baseUrl("$ACCESS_TOKEN_REQUEST_URL$accessToken")
                .addConverterFactory(GsonConverterFactory.create())
                .build()


        val retroInterfaceCreate: RetrofitInterface = retrofitInterface.create(RetrofitInterface::class.java)

        // receive the callback
        val interfaceRequest: Call<UserInfo> = retroInterfaceCreate.getUser()
        interfaceRequest.enqueue(object : Callback<UserInfo> {
            override fun onFailure(call: Call<UserInfo>?, t: Throwable?) {
                Log.d("requesting user data ","onFailure was called")
            }

            // get response and set the relevant values
            override fun onResponse(call: Call<UserInfo>?, response: Response<UserInfo>?) {
                Log.d("requesting user data ","onResponse was called")

                val userData: Data? = response?.body()?.data
                if (userData != null) {
                    liveUserName.value = userData.username
                    liveUserPictureUrl.value = userData.profile_picture
                }


            }

        })
    }

    interface RetrofitInterface {

        // asynchronously with a callback
        @GET(" ")
        fun getUser(): Call<UserInfo>
    }
}