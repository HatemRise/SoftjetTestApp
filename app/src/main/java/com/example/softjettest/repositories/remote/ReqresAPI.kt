package com.example.softjettest.repositories.remote

import com.example.softjettest.repositories.entities_and_models.UserListModel
import retrofit2.http.GET

interface ReqresAPI {
    companion object{
        const val BASE_URL = "https://reqres.in/api/"
    }

    @GET("users")
    suspend fun getUsers() : UserListModel
}