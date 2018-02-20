package com.epsilonmoves.instagramlogin.activity.fragments


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide

import com.epsilonmoves.instagramlogin.R
import com.epsilonmoves.instagramlogin.activity.view_model.InstaViewModel
import com.epsilonmoves.instagramlogin.activity.view_model.InstaViewModelInterface
import kotlinx.android.synthetic.main.fragment_user_details.*


/**
 * A simple [Fragment] subclass.
 */
class UserDetailsFragment : Fragment() {

    //view model
    lateinit var instaView: InstaViewModelInterface


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_details, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // view model
        instaView = ViewModelProviders.of(activity!!).get(InstaViewModel::class.java)
        // request user name and user photo
        instaView.requestUserNamePhoto()
        // observe the user name
        instaView.getLiveUserName().observe(this, Observer { user_details_user_name.text = it })
        // observe the user photo and load it using glide
        instaView.getLiveUserImage().observe(this, Observer { Glide.with(activity).load(it).into(user_details_user_image) })
    }
}
