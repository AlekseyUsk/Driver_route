package com.bignerdranch.android.driversroute.ui.fragmentsOfMonthsOfTheYear

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bignerdranch.android.driversroute.AdapterRV
import com.bignerdranch.android.driversroute.databinding.FragmentJanuaryBinding
import com.bignerdranch.android.driversroute.viewmodel.MainViewModel


class JanuaryFragment : Fragment() {

    private lateinit var binding: FragmentJanuaryBinding
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var adapter: AdapterRV

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentJanuaryBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.mvCurrentDate.toInt()
        viewModel.setTripModelRoute()
        addACard()
    }

    private fun addACard() = with(binding) {
        rvJanuary.layoutManager = LinearLayoutManager(activity)
        adapter = AdapterRV()
        rvJanuary.adapter = adapter

        viewModel.myLiveData.observe(viewLifecycleOwner) {
            if (viewModel.mvCurrentDate.toInt() == JANUARY) {
                viewModel.getTripModelRoute(it)
                adapter.submitList(viewModel.myList)
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = JanuaryFragment()
        const val JANUARY = 1
    }
}