package com.bignerdranch.android.driversroute.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bignerdranch.android.driversroute.AdapterRV
import com.bignerdranch.android.driversroute.R
import com.bignerdranch.android.driversroute.databinding.FragmentJanuaryBinding
import com.bignerdranch.android.driversroute.model.TripModel


class JanuaryFragment : Fragment() {

    private lateinit var binding: FragmentJanuaryBinding
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
                63546,
                "7:40",
                "8:40",
                "156:35"
            ),TripModel(
                "20.05.2023",
                "22:00",
                "Ивлев Данила табельный - 29170",
                "Инская - Черепаново",
                63567,
                "9:30",
                "11:40",
                "167:35"
            ),TripModel(
                "20.01.1989",
                "23:00",
                "Ивлев Данила табельный - 29170",
                "Инская - Тайга",
                63548,
                "7:40",
                "7:10",
                "180:39"
            ),TripModel(
                "20.01.1989",
                "23:00",
                "Ивлев Данила табельный - 29170",
                "Инская - Обь",
                63589,
                "5:46",
                "8:40",
                "200:35"
            ),TripModel(
                "20.01.1989",
                "23:00",
                "Ивлев Данила табельный - 29170",
                "Инская - Обь",
                63589,
                "5:46",
                "8:40",
                "200:35"
            ),TripModel(
                "20.01.1989",
                "23:00",
                "Ивлев Данила табельный - 29170",
                "Инская - Обь",
                63589,
                "5:46",
                "8:40",
                "200:35"
            ),TripModel(
                "20.01.1989",
                "23:00",
                "Ивлев Данила табельный - 29170",
                "Инская - Обь",
                63589,
                "5:46",
                "8:40",
                "200:35"
            ),TripModel(
                "20.01.1989",
                "23:00",
                "Ивлев Данила табельный - 29170",
                "Инская - Обь",
                63589,
                "5:46",
                "8:40",
                "200:35"
            ),TripModel(
                "20.01.1989",
                "23:00",
                "Ивлев Данила табельный - 29170",
                "Инская - Обь",
                63589,
                "5:46",
                "8:40",
                "200:35"
            ),TripModel(
                "20.01.1989",
                "23:00",
                "Ивлев Данила табельный - 29170",
                "Инская - Обь",
                63589,
                "5:46",
                "8:40",
                "200:35"
            ),TripModel(
                "20.01.1989",
                "23:00",
                "Ивлев Данила табельный - 29170",
                "Инская - Обь",
                63589,
                "5:46",
                "8:40",
                "200:35"
            ),TripModel(
                "20.01.1989",
                "23:00",
                "Ивлев Данила табельный - 29170",
                "Инская - Обь",
                63589,
                "5:46",
                "8:40",
                "200:35"
            ),TripModel(
                "20.01.1989",
                "23:00",
                "Ивлев Данила табельный - 29170",
                "Инская - Обь",
                63589,
                "5:46",
                "8:40",
                "200:35"
            ),TripModel(
                "20.01.1989",
                "23:00",
                "Ивлев Данила табельный - 29170",
                "Инская - Обь",
                63589,
                "5:46",
                "8:40",
                "200:35"
            ),TripModel(
                "20.01.1989",
                "23:00",
                "Ивлев Данила табельный - 29170",
                "Инская - Обь",
                63589,
                "5:46",
                "8:40",
                "200:35"
            ),TripModel(
                "20.01.1989",
                "23:00",
                "Ивлев Данила табельный - 29170",
                "Инская - Обь",
                63589,
                "5:46",
                "8:40",
                "200:35"
            ),TripModel(
                "20.01.1989",
                "23:00",
                "Ивлев Данила табельный - 29170",
                "Инская - Обь",
                63589,
                "5:46",
                "8:40",
                "200:35"
            ),TripModel(
                "20.01.1989",
                "23:00",
                "Ивлев Данила табельный - 29170",
                "Инская - Обь",
                63589,
                "5:46",
                "8:40",
                "200:35"
            ),TripModel(
                "20.01.1989",
                "23:00",
                "Ивлев Данила табельный - 29170",
                "Инская - Обь",
                63589,
                "5:46",
                "8:40",
                "200:35"
            ),TripModel(
                "20.01.1989",
                "23:00",
                "Ивлев Данила табельный - 29170",
                "Инская - Обь",
                63589,
                "5:46",
                "8:40",
                "200:35"
            )
        )
        adapter.submitList(myList)
    }

    companion object {
        @JvmStatic
        fun newInstance() = JanuaryFragment()
    }
}