package com.example.softjettest.di

import android.app.Application
import androidx.room.Room
import com.example.softjettest.repositories.local.db.LocalBase
import com.example.softjettest.repositories.remote.ReqresAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): LocalBase =
        Room.databaseBuilder(app, LocalBase::class.java, "Database")
            .allowMainThreadQueries()
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(ReqresAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideAPI(retrofit: Retrofit) : ReqresAPI =
        retrofit.create(ReqresAPI::class.java)
}