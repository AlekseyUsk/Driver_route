package com.bignerdranch.android.driversroute.ui.fragment.fragmentsOfMonthsOfTheYear

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bignerdranch.android.driversroute.AdapterRV
import com.bignerdranch.android.driversroute.databinding.FragmentFebruaryBinding
import com.bignerdranch.android.driversroute.repository.room.Repository
import com.bignerdranch.android.driversroute.viewmodel.MainViewModel
import kotlinx.coroutines.launch


class FebruaryFragment : Fragment() {

    private val repository = Repository()

    private lateinit var binding: FragmentFebruaryBinding
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var adapter: AdapterRV

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFebruaryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.setTripModelRoute()
        init()
        addACard()
        extractionRoom()
    }

    private fun extractionRoom() {
        viewModel.viewModelScope.launch {
            repository.getFebruaryRoomRoute().observe(viewLifecycleOwner) {
                viewModel.convertingFebruary(it).let {
                    adapter.submitList(it)
                }
            }
        }
    }

    private fun addACard() {
        viewModel.myLiveData.observe(viewLifecycleOwner) { tripModel ->
            if (tripModel.turnoutMonth == FEBRUARY_STR) {
                viewModel.writeANewCard(tripModel)
            }
        }
    }

    private fun init() = with(binding) {
        rvFebruary.layoutManager = LinearLayoutManager(activity)
        adapter = AdapterRV()
        rvFebruary.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = FebruaryFragment()
        const val FEBRUARY = 2
        const val FEBRUARY_STR = "февраль"
    }
}