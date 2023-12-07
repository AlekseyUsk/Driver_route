package com.bignerdranch.android.driversroute.repository.firebase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.bignerdranch.android.driversroute.R
import com.bignerdranch.android.driversroute.databinding.FragmentFireBaseInfoBinding
import com.bignerdranch.android.driversroute.databinding.FragmentMainBinding

class FireBaseInfoFragment : Fragment() {

    private lateinit var binding: FragmentFireBaseInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFireBaseInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbarMenuWithNavigation()
    }

    private fun toolbarMenuWithNavigation() {
        //добавил toolbar
        val toolbar = binding.toolbarFireBaseInfo
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.setTitle(R.string.title_app)

        //получаем ссылку на котролер навигации из хоста
        val navHostFragment = requireActivity().supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        //связываем панель инструментов с графои навигации
        val builder = AppBarConfiguration.Builder(navController.graph)
        val appBarConfiguration = builder.build()
        //применяет конфигурацию к панели инструментов
        toolbar.setupWithNavController(navController, appBarConfiguration)
    }
}