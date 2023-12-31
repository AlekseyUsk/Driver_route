package com.bignerdranch.android.driversroute.ui.fragment.fragmentsOfMonthsOfTheYear

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bignerdranch.android.driversroute.AdapterRV
import com.bignerdranch.android.driversroute.databinding.FragmentSeptemberBinding
import com.bignerdranch.android.driversroute.repository.room.Repository
import com.bignerdranch.android.driversroute.viewmodel.MainViewModel
import kotlinx.coroutines.launch


class SeptemberFragment : Fragment() {

    private val repository = Repository()

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

        viewModel.setTripModelRoute()
        init()
        addACard()
        extractionRoom()
    }

    private fun extractionRoom() {
        viewModel.viewModelScope.launch {
            repository.getSeptemberRoomRoute().observe(viewLifecycleOwner) {
                viewModel.convertingSeptember(it).let {
                    adapter.submitList(it)
                }
            }
        }
    }

    private fun addACard() {
        viewModel.myLiveData.observe(viewLifecycleOwner) { tripModel ->
            if (tripModel.turnoutMonth == SEPTEMBER_STR) {
                viewModel.writeANewCard(tripModel)
            }
        }
    }

    private fun init() = with(binding) {
        rvSeptember.layoutManager = LinearLayoutManager(activity)
        adapter = AdapterRV()
        rvSeptember.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = SeptemberFragment()
        const val SEPTEMBER = 9
        const val SEPTEMBER_STR = "сентябрь"
    }
}