package com.bignerdranch.android.driversroute.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.bignerdranch.android.driversroute.databinding.FragmentDataEntryBinding
import com.bignerdranch.android.driversroute.viewmodel.MainViewModel

class DataEntryFragment() : Fragment() {

    private lateinit var binding: FragmentDataEntryBinding
    private val viewModel: MainViewModel by activityViewModels()

    private lateinit var editDate: String
    private lateinit var editAssistant: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDataEntryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClick(view)
    }

    private fun sendMessage() {
        editDate = binding.dateEntry.text.toString()
        editAssistant = binding.assistant.text.toString()

        val action = DataEntryFragmentDirections.actionDataEntryFragmentToMainFragment(editDate,editAssistant)
        view?.findNavController()?.navigate(action)
        Log.d("@@@", "sendMessage  $action")
    }

    private fun onClick(view: View){
        binding.buttonSaveAddData.setOnClickListener {
            sendMessage()
        }
    }
}
