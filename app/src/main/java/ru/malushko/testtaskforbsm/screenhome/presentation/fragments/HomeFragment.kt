package ru.malushko.testtaskforbsm.screenhome.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import ru.malushko.testtaskforbsm.databinding.FragmentHomeBinding
import ru.malushko.testtaskforbsm.screenhome.domain.entities.Category
import ru.malushko.testtaskforbsm.screenhome.presentation.adapters.categoriesadapters.CategoriesAdapter
import ru.malushko.testtaskforbsm.screenhome.presentation.viewModels.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = _binding ?: throw RuntimeException("FragmentHomeBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CategoriesAdapter()
        adapter.onCategoryClickListener = object : CategoriesAdapter.OnCategoryClickListener {
            override fun onCategoryClick(category: Category) {
                viewModel.selectCat(category.id)

            }
        }

        binding.rvSelectCategory.adapter=adapter
        viewModel=ViewModelProvider(this)[HomeViewModel::class.java]
        viewModel.categoriesList.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
    }


}