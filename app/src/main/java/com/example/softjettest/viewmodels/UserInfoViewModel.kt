package com.example.softjettest.viewmodels

import androidx.lifecycle.ViewModel
import com.example.softjettest.repositories.Repository
import com.example.softjettest.repositories.entities_and_models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserInfoViewModel @Inject constructor(
    repository: Repository
): ViewModel() {
    lateinit var user: User
}