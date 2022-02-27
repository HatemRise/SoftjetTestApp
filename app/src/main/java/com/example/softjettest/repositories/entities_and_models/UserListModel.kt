package com.example.softjettest.repositories.entities_and_models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserListModel(
    @SerializedName("data")
    @Expose
    val data: List<User>
)