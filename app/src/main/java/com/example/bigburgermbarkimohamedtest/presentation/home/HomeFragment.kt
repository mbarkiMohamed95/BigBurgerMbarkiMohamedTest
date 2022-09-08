package com.example.bigburgermbarkimohamedtest.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bigburgermbarkimohamedtest.databinding.FragmentHomeBinding
import com.example.bigburgermbarkimohamedtest.helpers.states.DataState
import com.example.bigburgermbarkimohamedtest.presentation.home.adapter.BurgerAdapter
import com.example.bigburgermbarkimohamedtest.presentation.home.homeAction.HomeIntent
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {
    @Inject
    lateinit var burgerAdapter: BurgerAdapter
    private val viewModel: HomeViewModel    by viewModels()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        var mView =  binding.root
        setUpAdapter()
        loadBurgers()
        observeBurgersResponse()
        return mView
    }
    fun loadBurgers(){
        viewModel.handleAction(HomeIntent.LoadBurgers)
    }
    private fun setUpAdapter() {
        val layoutManager = LinearLayoutManager(requireContext())
        binding.burgerList.layoutManager = layoutManager
        binding.burgerList.adapter = burgerAdapter
    }

    fun observeBurgersResponse(){
        viewModel.dataState.observe(viewLifecycleOwner) {
            when(it){
                is DataState.Success ->{
                    binding.progressBar.visibility = View.GONE
                    burgerAdapter.setBurgers(it.data)
                }
                is DataState.Error ->{
                    binding.progressBar.visibility = View.GONE
                    Snackbar.make(
                        requireView(),
                        it.exception.message?:"null data",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

}