package ru.malushko.testtaskforbsm.screenhome.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import ru.malushko.testtaskforbsm.R
import ru.malushko.testtaskforbsm.databinding.FragmentHomeBinding
import ru.malushko.testtaskforbsm.databinding.ItemBestSellerBinding
import ru.malushko.testtaskforbsm.screenhome.domain.entities.BestSeller
import ru.malushko.testtaskforbsm.screenhome.domain.entities.Category
import ru.malushko.testtaskforbsm.screenhome.presentation.adapters.bestselleradapters.BestSellerAdapter
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

        binding.icHomeFilter.setOnClickListener {
            openFilterController()
        }

        val categoriesAdapter = CategoriesAdapter(context)
        binding.rvSelectCategory.adapter = categoriesAdapter
        viewModel.categoriesList.observe(viewLifecycleOwner) {
            categoriesAdapter.submitList(it)
        }
        categoriesAdapter.onCategoryClickListener =
            object : CategoriesAdapter.OnCategoryClickListener {
                override fun onCategoryClick(category: Category) {
                    viewModel.selectCat(category.id)
                    if(category.id!=0){
                        binding.homeWidgetsGroup.visibility=View.GONE
                        binding.homeError.visibility=View.VISIBLE
                    }else{
                        binding.homeWidgetsGroup.visibility=View.VISIBLE
                        binding.homeError.visibility=View.GONE
                    }
                }
            }

        val homeStoreAdapter = HomeStoreAdapter()
        binding.vpagerHomeHotSales.adapter = homeStoreAdapter
        binding.vpagerHomeHotSales.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewModel.homeStoreList.observe(viewLifecycleOwner) {
            homeStoreAdapter.submitList(it)
        }

        val bestSellerAdapter = BestSellerAdapter(context)
        binding.rvHomeBestSeller.adapter = bestSellerAdapter
        viewModel.bestSellerList.observe(viewLifecycleOwner) {
            bestSellerAdapter.submitList(it)
        }
        bestSellerAdapter.onBestSellerClickListener =
            object : BestSellerAdapter.OnBestSellerClickListener {
                override fun onFavoriteClick(
                    bestSellerItem: BestSeller,
                    hg: ItemBestSellerBinding
                ) {
                    viewModel.onBestSellerFavoriteClick(bestSellerItem)
                    if (bestSellerItem.isFavorites == true) {
                        hg.rvBestSellerFavorite.setImageResource(R.drawable.ic_favorite)
                    } else {
                        hg.rvBestSellerFavorite.setImageResource(R.drawable.ic_favorite_not)
                    }
                }
            }
    }

    fun openFilterController() {
        with(binding.filterOptionsCard){
            filterOptions.visibility=View.VISIBLE
            btnFilterCloser.setOnClickListener {
                binding.filterOptionsCard.filterOptions.visibility=View.GONE
            }
            btnFilterDone.setOnClickListener {
                binding.filterOptionsCard.filterOptions.visibility=View.GONE
                Toast.makeText(context, "Your filters are accepted", Toast.LENGTH_SHORT).show()
            }
        }

    }

}