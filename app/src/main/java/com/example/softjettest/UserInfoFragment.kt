package com.example.softjettest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.softjettest.R
import com.example.softjettest.databinding.MainScreenFragmentBinding
import com.example.softjettest.databinding.UserInfoFragmentBinding
import com.example.softjettest.viewmodels.UserInfoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserInfoFragment : Fragment(R.layout.user_info_fragment) {
    private val userInfoViewMode by viewModels<UserInfoViewModel>()

    private var _binding: UserInfoFragmentBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<UserInfoFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = UserInfoFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userInfoViewMode.user = args.user
        binding.apply {
            Glide.with(view)
                .load(userInfoViewMode.user.avatar)
                .into(userInfoAvatar)
            userInfoEmail.text = userInfoViewMode.user.email
            userInfoFirstName.text = userInfoViewMode.user.firstName
            userInfoLastName.text = userInfoViewMode.user.lastName
        }
    }
}