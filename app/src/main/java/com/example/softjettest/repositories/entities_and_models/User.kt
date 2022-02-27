package com.example.softjettest.repositories.entities_and_models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "users")
@Parcelize
data class User(
    @PrimaryKey
    @ColumnInfo(name = "user_id")
    @Expose
    val id: Long,
    @Expose
    val email: String,
    @ColumnInfo(name = "first_name")
    @SerializedName("first_name")
    @Expose
    val firstName: String,
    @ColumnInfo(name = "last_name")
    @SerializedName("last_name")
    @Expose
    val lastName: String,
    @Expose
    val avatar: String
) : Parcelable