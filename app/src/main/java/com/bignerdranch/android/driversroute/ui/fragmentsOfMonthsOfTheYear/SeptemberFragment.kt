package com.bignerdranch.android.driversroute.ui.fragmentsOfMonthsOfTheYear

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bignerdranch.android.driversroute.AdapterRV
import com.bignerdranch.android.driversroute.R
import com.bignerdranch.android.driversroute.databinding.FragmentAprilBinding
import com.bignerdranch.android.driversroute.databinding.FragmentSeptemberBinding
import com.bignerdranch.android.driversroute.viewmodel.MainViewModel


class SeptemberFragment : Fragment() {

    private lateinit var binding: FragmentSeptemberBinding
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var adapter: AdapterRV

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSeptemberBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.mvCurrentDate.toInt()
        viewModel.setTripModelRoute()
        addACard()
    }

    private fun addACard() = with(binding) {
        rvSeptember.layoutManager = LinearLayoutManager(activity)
        adapter = AdapterRV()
        rvSeptember.adapter = adapter

        viewModel.myLiveData.observe(viewLifecycleOwner) {
            if (viewModel.mvCurrentDate.toInt() == SEPTEMBER) {
                viewModel.getTripModelRoute(it)
                adapter.submitList(viewModel.myList)
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SeptemberFragment()
        const val SEPTEMBER = 9
    }
}