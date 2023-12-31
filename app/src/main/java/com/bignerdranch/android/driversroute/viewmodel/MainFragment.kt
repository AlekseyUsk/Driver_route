package com.bignerdranch.android.driversroute.viewmodel

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.bignerdranch.android.driversroute.R
import com.bignerdranch.android.driversroute.databinding.FragmentMainBinding
import com.bignerdranch.android.driversroute.repository.firebase.FireBaseInfoFragment
import com.bignerdranch.android.driversroute.ui.fragment.fragmentsOfMonthsOfTheYear.*
import com.bignerdranch.android.driversroute.viewpager2.ViewPagerAdapter
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.internal.NavigationMenuView
import com.google.android.material.tabs.TabLayoutMediator
import java.text.SimpleDateFormat
import java.util.*

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentMainBinding

    private val fragmentsList = listOf<Fragment>(
        JanuaryFragment.newInstance(),
        FebruaryFragment.newInstance(),
        MarchFragment.newInstance(),
        AprilFragment.newInstance(),
        MayFragment.newInstance(),
        JuneFragment.newInstance(),
        JulioFragment.newInstance(),
        AgostoFragment.newInstance(),
        SeptemberFragment.newInstance(),
        OctoberFragment.newInstance(),
        NovemberFragment.newInstance(),
        DecemberFragment.newInstance()
    )
    private val fragmentsListTitles = listOf(
        "Январь",
        "февраль",
        "март",
        "апрель",
        "май",
        "июнь",
        "июль",
        "август",
        "сентябрь",
        "октябрь",
        "ноябрь",
        "декабрь"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        currentDateTime()
        onClick()
        init()
        monitoringOfTheReceivedData()


        toolbarMenuWithNavigation() //toolbar в связке с navigation
        setHasOptionsMenu(true) //добавляет панель меню в toolbar 2
    }

    //добавляет панель меню в toolbar 1
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        requireActivity().menuInflater.inflate(R.menu.menu, menu)
       return super.onCreateOptionsMenu(menu,inflater)
    }
    //реакция на клики меню toolbar 3
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = requireActivity().findNavController(R.id.nav_host_fragment)
        return item.onNavDestinationSelected(navController)
                || super.onOptionsItemSelected(item)
    }

    private fun toolbarMenuWithNavigation() {
        //добавил toolbar
        val toolbar = binding.toolbar
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.setTitle(R.string.title_app)

        //получаем ссылку на котролер навигации из хоста
        var navHostFragment = requireActivity().supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        //связываем панель инструментов с графои навигации
        val builder = AppBarConfiguration.Builder(navController.graph)
        val appBarConfiguration = builder.build()
        //применяет конфигурацию к панели инструментов
        toolbar.setupWithNavController(navController, appBarConfiguration)
    }

    private fun init() = with(binding) {
        val adapter = ViewPagerAdapter(activity as FragmentActivity, fragmentsList)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tab, pos ->
            tab.text = fragmentsListTitles[pos]
        }.attach()
    }

    private fun onClick() {
        binding.addRoute.setOnClickListener {
            val navController = view?.findNavController()
            view?.findNavController()?.navigate(R.id.action_mainFragment_to_dataEntryFragment)
        }
    }

    private fun currentDateTime() {
        binding.currentData.text =
            SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
        binding.currentTime.text = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
    }

    private fun monitoringOfTheReceivedData() = with(viewModel) {
        getDate.value = MainFragmentArgs.fromBundle(requireArguments()).receivedDate
        getAssistant.value = MainFragmentArgs.fromBundle(requireArguments()).receivedAssistant
        getTime.value = MainFragmentArgs.fromBundle(requireArguments()).receivedTime
        getRoute.value = MainFragmentArgs.fromBundle(requireArguments()).receivedRoute
        getEm.value = MainFragmentArgs.fromBundle(requireArguments()).receivedEm
        getEndOfWork.value = MainFragmentArgs.fromBundle(requireArguments()).receivedEndOfWork
        getWorking.value = MainFragmentArgs.fromBundle(requireArguments()).receivedWorking
        getFinalHours.value = MainFragmentArgs.fromBundle(requireArguments()).receivedFinalHours
        getMonth.value = MainFragmentArgs.fromBundle(requireArguments()).receivedMonth
    }
}
