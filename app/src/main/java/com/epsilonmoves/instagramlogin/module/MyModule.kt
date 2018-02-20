package com.epsilonmoves.instagramlogin.module

import com.epsilonmoves.instagramlogin.web_view_client.MyWebViewClient
import org.koin.dsl.module.applicationContext


val webViewModule = applicationContext { bean { MyWebViewClient() } }