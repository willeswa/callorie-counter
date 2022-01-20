package app.monkpad.caloriecounter.presentation.homescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import app.monkpad.caloriecounter.databinding.HomeFragmentBinding
import app.monkpad.caloriecounter.framework.CalorieCounterViewModelFactory

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by activityViewModels {
        CalorieCounterViewModelFactory
    }

    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

}