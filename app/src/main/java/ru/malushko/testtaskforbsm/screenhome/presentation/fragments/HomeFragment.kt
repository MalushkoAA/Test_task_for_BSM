package ru.malushko.testtaskforbsm.screenhome.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import ru.malushko.testtaskforbsm.databinding.FragmentHomeBinding
import ru.malushko.testtaskforbsm.screenhome.domain.entities.Category
import ru.malushko.testtaskforbsm.screenhome.domain.entities.HomeStore
import ru.malushko.testtaskforbsm.screenhome.presentation.adapters.categoriesadapters.CategoriesAdapter
import ru.malushko.testtaskforbsm.screenhome.presentation.adapters.homestoreadapters.HomeStoreAdapter
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
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        val categoriesAdapter = CategoriesAdapter()
        categoriesAdapter.onCategoryClickListener = object : CategoriesAdapter.OnCategoryClickListener {
            override fun onCategoryClick(category: Category) {
                viewModel.selectCat(category.id)
            }
        }
        binding.rvSelectCategory.adapter = categoriesAdapter
        viewModel.categoriesList.observe(viewLifecycleOwner) {
            categoriesAdapter.submitList(it)
        }

        val homeStoreAdapter = HomeStoreAdapter()
        binding.vpagerHomeHotSales.adapter = homeStoreAdapter
        binding.vpagerHomeHotSales.orientation=ViewPager2.ORIENTATION_HORIZONTAL
        viewModel.homeStoreList.observe(viewLifecycleOwner) {
            homeStoreAdapter.submitList(it)
        }

    }


}