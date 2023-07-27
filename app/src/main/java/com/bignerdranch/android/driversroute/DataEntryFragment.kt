package com.bignerdranch.android.driversroute

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.bignerdranch.android.driversroute.databinding.FragmentDataEntryBinding
import com.bignerdranch.android.driversroute.model.TripModel

class DataEntryFragment() : Fragment() {

    private lateinit var tripModel: TripModel

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

    private fun updateDataEntry(binding: FragmentDataEntryBinding){
            val item = TripModel(
                date = binding.date.toString(),
                time = binding.time.toString(),
                assistant = binding.assistant.toString(),
                route = binding.route.toString(),
                em = binding.em.toString(),
                endOfWork = binding.endOfWork.toString(),
                working = binding.working.toString(),
                final_hours = binding.finalHours.toString()
            )
            viewModel.myLiveData.value = item
    }
//FIX ME хотел аргумениты передать но у меня не те данные
    private fun onClick() {
      //  var messageRoute =
        binding.buttonSaveAddData.setOnClickListener {
          //  val action = DataEntryFragmentDirections.actionDataEntryFragmentToFebruaryFragment()
            val navController = view?.findNavController()
            view?.findNavController()?.navigate(R.id.action_dataEntryFragment_to_februaryFragment)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = DataEntryFragment()
    }
}