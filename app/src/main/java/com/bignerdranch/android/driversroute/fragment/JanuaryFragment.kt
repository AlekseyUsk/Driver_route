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

        initRcView()
    }

    private fun initRcView() = with(binding) {
        rvJanuary.layoutManager = LinearLayoutManager(activity)
        adapter = AdapterRV()
        rvJanuary.adapter = adapter
        //заглушка моими данными
        val myList = listOf<TripModel>(
            TripModel(
                "20.01.1989",
                "23:00",
                "Ивлев Данила 29170",
                "Инская - Московка",
                63547,
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