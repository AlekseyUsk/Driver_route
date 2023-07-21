package com.bignerdranch.android.driversroute.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bignerdranch.android.driversroute.R


class MarchFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_julio, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = MarchFragment()
    }
}