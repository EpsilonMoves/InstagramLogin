package com.epsilonmoves.instagramlogin.web_view_client

import android.webkit.WebView
import android.webkit.WebViewClient
import com.epsilonmoves.instagramlogin.utils.ACCESS_TOKEN
import com.epsilonmoves.instagramlogin.utils.REDIRECT_PREFIX
import com.epsilonmoves.instagramlogin.utils.getStringAfter

class MyWebViewClient : WebViewClient() {

    // call back function
    private lateinit var callBackFunction: () -> Unit
    fun setLoginCallback(function: () -> Unit) { callBackFunction = function }

    // token function
    private lateinit var setTokenFunction:(String) -> Unit
    fun setTokenFunc(tok: (String) -> Unit) { setTokenFunction = tok }

    private fun activateStringFunction(s:String, tok: (String) -> Unit){ tok(s) }

    override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
        if (url.startsWith(REDIRECT_PREFIX, true)) { // redirect uri!
            val token = url.getStringAfter(ACCESS_TOKEN) // get token from url
            activateStringFunction(token, setTokenFunction)
            callBackFunction()
            return true // don’t load the page
        }
        return false// load the page
    }
}


