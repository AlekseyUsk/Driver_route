package com.bignerdranch.android.driversroute.ui.fragment

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.bignerdranch.android.driversroute.R
import com.bignerdranch.android.driversroute.databinding.FragmentDataEntryBinding
import com.bignerdranch.android.driversroute.viewmodel.MainViewModel
import java.text.SimpleDateFormat
import java.util.*

class DataEntryFragment() : Fragment() {

    private lateinit var binding: FragmentDataEntryBinding
    private val viewModel: MainViewModel by activityViewModels()

    private lateinit var editDate: String
    private lateinit var editAssistant: String
    private lateinit var editTime: String
    private lateinit var editRoute: String
    private lateinit var editEm: String
    private lateinit var editEndOfWork: String
    private lateinit var editWorking: String
    private lateinit var editFinalHours: String
    private lateinit var editMonth: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDataEntryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        automaticRouteFillIn()
        onClick(view)
    }

    private fun sendMessage() = with(binding) {
        editDate = dateEntry.text.toString()
        editAssistant = assistant.text.toString()
        editTime = time.text.toString()
        editRoute = route.text.toString()
        editEm = em.text.toString()
        editEndOfWork = endOfWork.text.toString()
        editWorking = working.text.toString()
        editFinalHours = finalHours.text.toString()
        editMonth = turnout.text.toString()

        val action = DataEntryFragmentDirections.actionDataEntryFragmentToMainFragment(
            editDate,
            editAssistant,
            editTime,
            editRoute,
            editEm,
            editEndOfWork,
            editWorking,
            editFinalHours,
            editMonth
        )
        view?.findNavController()?.navigate(action)
    }

    private fun onClick(view: View) {
        binding.buttonSaveAddData.setOnClickListener {
            MediaPlayer.create(requireContext(),R.raw.woomen).start()
            sendMessage()
        }
    }

    private fun automaticRouteFillIn() = with(binding) {
        val autoListRoute = resources.getStringArray(R.array.route)
        val autoRouteAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, autoListRoute)
        route.threshold = 0
        route.setAdapter(autoRouteAdapter)

        val autoListAssistant = resources.getStringArray(R.array.assistant)
        val autoAssistantAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, autoListAssistant)
        assistant.threshold = 0
        assistant.setAdapter(autoAssistantAdapter)

        val autoListMonth = resources.getStringArray(R.array.month)
        val autoMonthAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, autoListMonth)
        turnout.threshold = 0
        turnout.setAdapter(autoMonthAdapter)
    }
}