package com.bignerdranch.android.driversroute.ui.fragment.fragmentsOfMonthsOfTheYear

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bignerdranch.android.driversroute.AdapterRV
import com.bignerdranch.android.driversroute.R
import com.bignerdranch.android.driversroute.databinding.FragmentOctoberBinding
import com.bignerdranch.android.driversroute.databinding.FragmentSeptemberBinding
import com.bignerdranch.android.driversroute.viewmodel.MainViewModel


class OctoberFragment : Fragment() {

    private lateinit var binding: FragmentOctoberBinding
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var adapter: AdapterRV

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOctoberBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.mvCurrentDate.toInt()
        viewModel.setTripModelRoute()
        addACard()
    }

    private fun addACard() = with(binding) {
        rvOctober.layoutManager = LinearLayoutManager(activity)
        adapter = AdapterRV()
        rvOctober.adapter = adapter

        viewModel.myLiveData.observe(viewLifecycleOwner) {
            if(viewModel.mvCurrentDate.toInt() == OCTOBER){
                viewModel.getTripModelRoute(it)
                adapter.submitList(viewModel.myList)
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = OctoberFragment()
        const val OCTOBER = 10
    }
}