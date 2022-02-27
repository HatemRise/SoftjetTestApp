package com.example.softjettest.repositories

import androidx.room.withTransaction
import com.example.softjettest.repositories.remote.ReqresAPI
import com.example.softjettest.util.networkBoundResource
import com.example.softjettest.repositories.local.db.LocalBase
import javax.inject.Inject

class Repository @Inject constructor(
    private val db: LocalBase,
    private val api: ReqresAPI
) {
    private val dao = db.dao()

    fun getUsers() = networkBoundResource(
        query = {
            dao.getAllUsers()
        },
        fetch = {
            api.getUsers().data
        },
        saveFetchResult = {
            db.withTransaction{
                dao.deleteAllUsers()
                dao.insertUsers(it)
            }
        }
    )
}