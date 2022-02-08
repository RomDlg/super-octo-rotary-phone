package fr.limentic_romdlg.super_octo_rotary_phone.api

import okhttp3.OkHttpClient


object APIClient {

    private const val BASE_URL: String = "http://home.kahriboo.com:3104/"

    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder().build()
    }


}