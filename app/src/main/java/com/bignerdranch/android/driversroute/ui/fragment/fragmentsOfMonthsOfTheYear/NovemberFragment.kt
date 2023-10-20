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
import com.bignerdranch.android.driversroute.databinding.FragmentNovemberBinding
import com.bignerdranch.android.driversroute.repository.Repository
import com.bignerdranch.android.driversroute.viewmodel.MainViewModel
import kotlinx.coroutines.launch


class NovemberFragment : Fragment() {

    private val repository = Repository()

    private lateinit var binding: FragmentNovemberBinding
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var adapter: AdapterRV

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNovemberBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.setTripModelRoute()
        init()
        addACard()
      //  exit()
    }

    private fun addACard() {
        viewModel.myLiveData.observe(viewLifecycleOwner) { tripModel ->
            if (tripModel.turnoutMonth == NOVEMBER_STR){
                viewModel.writeANewCard(tripModel).let {
                    for (i in it){
                        if (i.turnoutMonth == NOVEMBER_STR){
                            adapter.submitList(it)
                        }
                    }
                }
            }
        }
    }

   private fun exit() {
        viewModel.viewModelScope.launch {
            repository.getNovemberRoomRoute().observe(viewLifecycleOwner) {
                viewModel.convertingSavedDataFromATableToTripModel(it).let {
                    for (i in it) {
                        if (i.turnoutMonth == NOVEMBER_STR) {
                            adapter.submitList(it)
                        }
                    }
                }
            }
        }
    }

    private fun init() = with(binding) {
        rvNovember.layoutManager = LinearLayoutManager(activity)
        adapter = AdapterRV()
        rvNovember.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = NovemberFragment()
        const val NOVEMBER = 11
        const val NOVEMBER_STR = "ноябрь"
    }
}