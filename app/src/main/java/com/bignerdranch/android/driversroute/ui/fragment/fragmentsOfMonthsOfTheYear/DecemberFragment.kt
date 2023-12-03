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
import com.bignerdranch.android.driversroute.databinding.FragmentDecemberBinding
import com.bignerdranch.android.driversroute.repository.room.Repository
import com.bignerdranch.android.driversroute.viewmodel.MainViewModel
import kotlinx.coroutines.launch


class DecemberFragment : Fragment() {

    private val repository = Repository()

    private lateinit var binding: FragmentDecemberBinding
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var adapter: AdapterRV

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDecemberBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.setTripModelRoute()
        init()
        addACard()
        extractionRoom()
        viewModel.viewModelScope.launch {
           // repository.cardDeletion() //FIX ME пробовал удалять из бд декабрь только перезагружай аппп игаче несрабает
        }
    }

    private fun extractionRoom() {
        viewModel.viewModelScope.launch {
            repository.getDecemberRoomRoute().observe(viewLifecycleOwner) {
                viewModel.convertingDecember(it).let {
                    adapter.submitList(it)
                }
            }
        }
    }

    private fun addACard() {
        viewModel.myLiveData.observe(viewLifecycleOwner) { tripModel ->
            if (tripModel.turnoutMonth == DECEMBER_STR) {
                viewModel.writeANewCard(tripModel)
            }
        }
    }

    private fun init() = with(binding) {
        rvDecember.layoutManager = LinearLayoutManager(activity)
        adapter = AdapterRV()
        rvDecember.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = DecemberFragment()
        const val DECEMBER = 12
        const val DECEMBER_STR = "декабрь"
    }
}