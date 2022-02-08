package fr.limentic_romdlg.super_octo_rotary_phone.api

import fr.limentic_romdlg.super_octo_rotary_phone.Map
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {

    //Retourne la liste des maps
    @GET("iut/game-list")
    suspend fun getGameList(): Response<MutableList<Map>>

    //Retourne une map par son id
    @GET("iut/game/{id}")
    suspend fun getGameById(@Path("id") id: Int):  Response<Map>
}