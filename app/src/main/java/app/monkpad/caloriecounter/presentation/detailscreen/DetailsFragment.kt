package app.monkpad.caloriecounter.presentation.detailscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import app.monkpad.caloriecounter.databinding.DetailsFragmentBinding
import app.monkpad.caloriecounter.framework.CalorieCounterViewModelFactory
import app.monkpad.caloriecounter.presentation.searchscreen.SearchViewModel

class DetailsFragment : Fragment() {

    private val viewModel: DetailViewModel by viewModels {
        CalorieCounterViewModelFactory
    }

    //We are scoping this the the Activity because of the calculating state
    private val searchViewModel: SearchViewModel by activityViewModels {
        CalorieCounterViewModelFactory
    }

    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DetailsFragmentBinding.inflate(inflater, container, false)

        binding.detailViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.calculateCalories(args.foodNameArg)
        searchViewModel.finishCalculating()

        viewModel.reset.observe(viewLifecycleOwner, {
            if (it) {
                findNavController().popBackStack()
                viewModel.finishResetting()
            }
        })

        return binding.root
    }
}