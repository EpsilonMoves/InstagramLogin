package com.epsilonmoves.instagramlogin.activity.fragments


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.epsilonmoves.instagramlogin.R
import com.epsilonmoves.instagramlogin.activity.view_model.InstaViewModel
import com.epsilonmoves.instagramlogin.activity.view_model.InstaViewModelInterface
import com.epsilonmoves.instagramlogin.utils.INSTA_LOGIN_URL
import com.epsilonmoves.instagramlogin.web_view_client.MyWebViewClient
import kotlinx.android.synthetic.main.fragment_instagram_login_fregment.*
import org.koin.android.ext.android.inject


/**
 * A simple [Fragment] subclass.
 */
class InstagramLoginFragment: Fragment() {

    // lazy inject BusinessService
    private val webViewClient: MyWebViewClient by inject()
    //view model
    lateinit var instaView: InstaViewModelInterface

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_instagram_login_fregment, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // view model
        instaView = ViewModelProviders.of(activity!!).get(InstaViewModel::class.java)

        //val myWeb = MyWebViewClient()
        // callback after login
        webViewClient.setLoginCallback({fragmentManager!!.beginTransaction().replace(R.id.activity_main_content_frame,  UserDetailsFragment()).commit()})
        // set the token
        webViewClient.setTokenFunc({instaView.setToken(it)})
        // set the web view client
        web_view.webViewClient = webViewClient
        // load the url
        web_view.loadUrl(INSTA_LOGIN_URL)

    }
}
