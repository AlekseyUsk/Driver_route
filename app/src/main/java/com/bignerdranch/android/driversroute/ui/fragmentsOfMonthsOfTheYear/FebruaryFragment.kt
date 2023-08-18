package com.bignerdranch.android.driversroute.ui.fragmentsOfMonthsOfTheYear

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bignerdranch.android.driversroute.AdapterRV
import com.bignerdranch.android.driversroute.databinding.FragmentFebruaryBinding
import com.bignerdranch.android.driversroute.model.TripModel
import com.bignerdranch.android.driversroute.viewmodel.MainViewModel


class FebruaryFragment : Fragment() {

    var listFebruary = listOf<TripModel>()

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

        setTripModelRoute()
        addACard()
    }

    private fun addACard() = with(binding) {
        rvFebruary.layoutManager = LinearLayoutManager(activity)
        adapter = AdapterRV()
        rvFebruary.adapter = adapter

        viewModel.myLiveData.observe(viewLifecycleOwner) {
            getTripModelRoute(it)
            adapter.submitList(viewModel.myList)
        }
    }

    //введеные данные пользователем обновляют карточку и добавляют ее в список
    private fun getTripModelRoute(item: TripModel): List<TripModel> = with(binding) {

        val itemUpdate = TripModel(
            date = item.date,
            time = item.time,
            assistant = item.assistant,
            route = item.route,
            em = item.em,
            endOfWork = item.endOfWork,
            working = item.working,
            finalHours = item.finalHours
        )
        viewModel.setList.add(itemUpdate)
        viewModel.myList = viewModel.setList.toList() as MutableList<TripModel>
        return viewModel.myList
    }

    //пользователь вводит данные
    private fun setTripModelRoute() {

        val itemStart = TripModel(
            date = "${viewModel.getDate.value}",
            time = "время явки ",
            assistant = "${viewModel.getAssistant.value}",
            route = "Инская - Болотное",
            em = "ЭМ - 35765",
            endOfWork = "",
            working = "",
            finalHours = ""
        )
        viewModel.myLiveData.value = itemStart
    }

    companion object {
        @JvmStatic
        fun newInstance() = FebruaryFragment()
    }

}