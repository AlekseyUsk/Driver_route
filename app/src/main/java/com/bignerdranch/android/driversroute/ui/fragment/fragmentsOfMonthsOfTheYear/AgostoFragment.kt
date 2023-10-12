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
import com.bignerdranch.android.driversroute.databinding.FragmentAgostoBinding
import com.bignerdranch.android.driversroute.repository.Repository
import com.bignerdranch.android.driversroute.viewmodel.MainViewModel
import kotlinx.coroutines.launch

class AgostoFragment : Fragment() {

    private val repository = Repository()

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

        viewModel.setTripModelRoute()
        init()
        addACard()
    }

    private fun addACard() {
        viewModel.myLiveData.observe(viewLifecycleOwner){
            viewModel.viewModelScope.launch {
                repository.getAgostoRoomRoute().observe(viewLifecycleOwner) {
                    viewModel.convertingSavedDataFromATableToTripModel(it)
                }
                viewModel.writeANewCard(it)
                adapter.submitList(viewModel.myList)
            }
        }
    }

    private fun init() = with(binding) {
        rvAgosto.layoutManager = LinearLayoutManager(activity)
        adapter = AdapterRV()
        rvAgosto.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = AgostoFragment()
        const val AGOSTO = 8
    }
}