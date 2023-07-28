package com.bignerdranch.android.driversroute.ui

import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.bignerdranch.android.driversroute.viewmodel.MainViewModel
import com.bignerdranch.android.driversroute.R
import com.bignerdranch.android.driversroute.databinding.FragmentDataEntryBinding
import com.bignerdranch.android.driversroute.model.TripModel
import kotlin.properties.Delegates.notNull

class DataEntryFragment() : Fragment() {

    private var entryDate by notNull<String>()
    lateinit var entryTime : String
    private var entryAssistant by notNull<String>()

    private lateinit var binding: FragmentDataEntryBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDataEntryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateDataEntry(binding)
        onClick()
    }

    private fun updateDataEntry(binding: FragmentDataEntryBinding) = with(binding){
       // entryDate = binding.date.text.toString()

        entryTime = "4444444444"


              Log.d("@@@", "!!!!!!!!!!!!!!!!!!  $entryTime")

        val item = TripModel(
            date = "",
            time = entryTime,
            assistant = "егорка",
            route = "",
            em = "",
            endOfWork = "",
            working = "",
            final_hours = ""
        )
        viewModel.myLiveData.value = item
        Log.d("@@@", "${item}")
    }

    private fun onClick() {
        binding.buttonSaveAddData.setOnClickListener {
            val navController = view?.findNavController()
            view?.findNavController()?.navigate(R.id.action_dataEntryFragment_to_februaryFragment)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = DataEntryFragment()
    }
}