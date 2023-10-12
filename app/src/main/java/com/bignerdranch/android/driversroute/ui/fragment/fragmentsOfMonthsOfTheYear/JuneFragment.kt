package com.bignerdranch.android.driversroute.ui.fragment.fragmentsOfMonthsOfTheYear

import android.bluetooth.BluetoothClass.Device.Major
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bignerdranch.android.driversroute.AdapterRV
import com.bignerdranch.android.driversroute.R
import com.bignerdranch.android.driversroute.databinding.FragmentAprilBinding
import com.bignerdranch.android.driversroute.databinding.FragmentJuneBinding
import com.bignerdranch.android.driversroute.viewmodel.MainViewModel


class JuneFragment : Fragment() {

    private lateinit var binding: FragmentJuneBinding
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var adapter: AdapterRV

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentJuneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.mvCurrentDate.toInt()
        viewModel.setTripModelRoute()
        init()
        addACard()
    }

    private fun addACard() {
        viewModel.myLiveData.observe(viewLifecycleOwner) {
            if (viewModel.mvCurrentDate.toInt() == JUNE) {
                viewModel.writeANewCard(it)
                adapter.submitList(viewModel.myList)
            }
        }
    }

    private fun init() = with(binding) {
        rvJune.layoutManager = LinearLayoutManager(activity)
        adapter = AdapterRV()
        rvJune.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = JuneFragment()
        const val JUNE = 6
    }
}