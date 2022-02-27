package com.example.softjettest.repositories.local.db

import androidx.room.*
import androidx.room.RoomDatabase
import com.example.softjettest.repositories.entities_and_models.User
import com.example.softjettest.repositories.local.UserDAO

@Database(
    entities = [User::class],
    version = 1, exportSchema = false
)
abstract class LocalBase : RoomDatabase(){
    abstract fun dao() : UserDAO
}