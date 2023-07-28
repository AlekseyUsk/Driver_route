package com.bignerdranch.android.driversroute.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bignerdranch.android.driversroute.AdapterRV
import com.bignerdranch.android.driversroute.viewmodel.MainViewModel
import com.bignerdranch.android.driversroute.databinding.FragmentJanuaryBinding
import com.bignerdranch.android.driversroute.model.TripModel


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

        initRcView()

    }

    private fun initRcView() = with(binding) {
        rvJanuary.layoutManager = LinearLayoutManager(activity)
        adapter = AdapterRV()
        rvJanuary.adapter = adapter
        val myList = listOf<TripModel>(
            TripModel(
                "20.01.1989",
                "23:00",
                "Ивлев Данила табельный - 29170",
                "Инская - Московка",
                "63546",
                "7:40",
                "8:40",
                "156:35"
            )
        )
        adapter.submitList(myList)
    }

    companion object {
        @JvmStatic
        fun newInstance() = JanuaryFragment()
    }
}