package com.example.softjettest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.softjettest.viewmodels.MainScreenViewModel
import com.example.softjettest.databinding.MainScreenFragmentBinding
import com.example.softjettest.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainScreenFragment : Fragment(R.layout.main_screen_fragment) {
    private var _binding: MainScreenFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<MainScreenViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainScreenFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val userAdapter = MainScreenUsersAdapter {
            val action = MainScreenFragmentDirections.actionMainScreenFragmentToUserInfoFragment(it)
            findNavController().navigate(action)
        }
        binding.apply {
            view.findViewById<RecyclerView>(R.id.main_screen_users_list).apply {
                adapter = userAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }

            viewModel.users.observe(requireActivity()) {
                val temp = it.data
                userAdapter.submitList(temp)
                mainScreenProgressbar.isVisible =
                    it is Resource.Loading && it.data.isNullOrEmpty()
                mainScreenErrorMessage.isVisible =
                    it is Resource.Error && it.data.isNullOrEmpty()
                mainScreenErrorMessage.text = it.error?.localizedMessage
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}