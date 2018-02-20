package com.epsilonmoves.instagramlogin.utils

// extension function to get the substring after the argument received string
fun String.getStringAfter(s: String): String = substring(this.lastIndexOf(s) + s.length)
