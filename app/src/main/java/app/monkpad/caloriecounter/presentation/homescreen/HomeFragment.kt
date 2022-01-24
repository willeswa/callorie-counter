package app.monkpad.caloriecounter.presentation.homescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import app.monkpad.caloriecounter.databinding.HomeFragmentBinding
import app.monkpad.caloriecounter.framework.CalorieCounterViewModelFactory
import app.monkpad.caloriecounter.framework.adapters.HomeScreenRecyclerAdapter
import app.monkpad.caloriecounter.interactions.CachedEntriesClickListener

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by activityViewModels {
        CalorieCounterViewModelFactory
    }

    private lateinit var adapter: HomeScreenRecyclerAdapter
    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = HomeFragmentBinding.inflate(inflater, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = HomeScreenRecyclerAdapter(CachedEntriesClickListener {
            val action = HomeFragmentDirections.actionHomeNavToDetailsNav(it.foodName)
            findNavController().navigate(action)
        })

        binding.mainScreenRecycler.adapter = adapter
    }

}