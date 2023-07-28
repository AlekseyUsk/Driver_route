package com.bignerdranch.android.driversroute.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bignerdranch.android.driversroute.AdapterRV
import com.bignerdranch.android.driversroute.ui.DataEntryFragment
import com.bignerdranch.android.driversroute.viewmodel.MainViewModel
import com.bignerdranch.android.driversroute.databinding.FragmentFebruaryBinding
import com.bignerdranch.android.driversroute.model.TripModel


class FebruaryFragment : Fragment() {

    lateinit var dataEntryFragment: DataEntryFragment

    lateinit var tripModel: TripModel

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

        update()
    }

    private fun update() = with(binding) {
        rvFebruary.layoutManager = LinearLayoutManager(activity)
        adapter = AdapterRV()
        rvFebruary.adapter = adapter

       viewModel.myLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(getTripModelRoute(it))

        }
    }

    //фун обработка данных обсерверу
    private fun getTripModelRoute(item: TripModel): List<TripModel> {

        val list = arrayListOf<TripModel>()

        val item = TripModel(
            date = item.date,
            time = item.time,
            assistant = item.assistant,
            route = item.route,
            em = item.em,
            endOfWork = item.endOfWork,
            working = item.working,
            final_hours = item.final_hours
        )
        list.add(item)
        return list

    }

    companion object {
        @JvmStatic
        fun newInstance() = FebruaryFragment()
    }
}