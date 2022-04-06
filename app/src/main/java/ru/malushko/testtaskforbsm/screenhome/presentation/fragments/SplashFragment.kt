package ru.malushko.testtaskforbsm.screenhome.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.malushko.testtaskforbsm.R
import ru.malushko.testtaskforbsm.databinding.FragmentSplashBinding
import ru.malushko.testtaskforbsm.screenhome.presentation.viewModels.HomeViewModel


class SplashFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel

    private var _binding: FragmentSplashBinding? = null
    private val binding: FragmentSplashBinding
        get() = _binding ?: throw RuntimeException("FragmentSplashBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        lifecycleScope.launch {
            delay(1300)
            if (viewModel.loadingStatus) {
                findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
            } else {
                binding.connectionError.visibility = View.VISIBLE
            }
        }

    }


}