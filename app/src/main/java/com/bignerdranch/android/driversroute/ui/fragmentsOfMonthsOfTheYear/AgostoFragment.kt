package com.bignerdranch.android.driversroute.ui.fragmentsOfMonthsOfTheYear

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bignerdranch.android.driversroute.AdapterRV
import com.bignerdranch.android.driversroute.R
import com.bignerdranch.android.driversroute.databinding.FragmentAgostoBinding
import com.bignerdranch.android.driversroute.databinding.FragmentFebruaryBinding
import com.bignerdranch.android.driversroute.viewmodel.MainViewModel

class AgostoFragment : Fragment() {


    private lateinit var binding: FragmentAgostoBinding
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var adapter: AdapterRV

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAgostoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.mvCurrentDate.toInt()
        viewModel.setTripModelRoute()
        addACard()
    }

    private fun addACard() = with(binding) {
        rvAgosto.layoutManager = LinearLayoutManager(activity)
        adapter = AdapterRV()
        rvAgosto.adapter = adapter

        viewModel.myLiveData.observe(viewLifecycleOwner) {
            if(viewModel.mvCurrentDate.toInt() == AGOSTO){
                viewModel.getTripModelRoute(it)
                adapter.submitList(viewModel.myList)
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = AgostoFragment()
        const val AGOSTO = 8
    }
}