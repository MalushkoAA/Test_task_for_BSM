package ru.malushko.testtaskforbsm.screenhome.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import ru.malushko.testtaskforbsm.R
import ru.malushko.testtaskforbsm.screenhome.data.datasource.DataSource
import ru.malushko.testtaskforbsm.screenhome.data.datasource.model.CategoriesDataModel
import ru.malushko.testtaskforbsm.screenhome.data.mapper.HomeMapper
import ru.malushko.testtaskforbsm.screenhome.data.network.ApiFactory
import ru.malushko.testtaskforbsm.screenhome.data.network.models.HomeStoreDto
import ru.malushko.testtaskforbsm.screenhome.domain.entities.BestSeller
import ru.malushko.testtaskforbsm.screenhome.domain.entities.Category
import ru.malushko.testtaskforbsm.screenhome.domain.entities.HomeStore
import ru.malushko.testtaskforbsm.screenhome.domain.repo.HomeRepository
import java.lang.Exception

class HomeRepoImpl : HomeRepository {

    private val mapper = HomeMapper()
    private val apiService = ApiFactory.apiService
    private val categoriesListLD = MutableLiveData<List<CategoriesDataModel>>()
    private val categoriesList = DataSource.categoriesDsList
    private val _homeStoreListDto = MutableLiveData<List<HomeStoreDto>>()
    val homeStoreListDto: LiveData<List<HomeStoreDto>>
        get() = _homeStoreListDto


    override fun getCategoriesList(): LiveData<List<Category>> {
        categoriesListLD.value = categoriesList
        return Transformations.map(categoriesListLD) {
            it.map {
                mapper.mapDsToEntity(it)
            }
        }
    }

    override fun selectCategory(id: Int) {
        changeSelect(id)
        changeIcons()
    }

    override fun getHomeStoreList(): LiveData<List<HomeStore>> {
        return Transformations.map(homeStoreListDto) {
            it.map {
                mapper.mapDtoToEntity(it)
            }
        }
    }

    override fun getBestSellerList(): LiveData<List<BestSeller>> {
        TODO("Not yet implemented")
    }

    override fun getBestSeller(id: Int): LiveData<BestSeller> {
        TODO("Not yet implemented")
    }

    override suspend fun loadData() {
        try {
            _homeStoreListDto.value = apiService.getHomeResponse().homeStore
        } catch (e: Exception) {
        }
    }


    private fun changeSelect(id: Int) {
        for (category in categoriesList) {
            category.isSelected = category.id == id
        }
    }

    private fun changeIcons() {
        for (category in categoriesList) {
            when (category.name) {
                "Phones" -> {
                    if (category.isSelected) with(category) {
                        image = R.drawable.ic_category_phone_selected
                        circleColor = R.drawable.ic_circle_primary
                        textColor = R.color.primary
                    } else with(category) {
                        image = R.drawable.ic_category_phone
                        circleColor = R.drawable.ic_circle_whie
                        textColor = R.color.secondary
                    }
                }
                "Computer" -> {
                    if (category.isSelected) with(category) {
                        image = R.drawable.ic_category_computer_selected
                        circleColor = R.drawable.ic_circle_primary
                        textColor = R.color.primary
                    } else with(category) {
                        image = R.drawable.ic_category_computer
                        circleColor = R.drawable.ic_circle_whie
                        textColor = R.color.secondary
                    }
                }
                "Health" -> {
                    if (category.isSelected) with(category) {
                        image = R.drawable.ic_category_health_selected
                        circleColor = R.drawable.ic_circle_primary
                        textColor = R.color.primary
                    } else with(category) {
                        image = R.drawable.ic_category_health
                        circleColor = R.drawable.ic_circle_whie
                        textColor = R.color.secondary
                    }
                }
                "Books" -> {
                    if (category.isSelected) with(category) {
                        image = R.drawable.ic_category_books_selected
                        circleColor = R.drawable.ic_circle_primary
                        textColor = R.color.primary
                    } else with(category) {
                        image = R.drawable.ic_category_books
                        circleColor = R.drawable.ic_circle_whie
                        textColor = R.color.secondary
                    }
                }
                "Pets" -> {
                    if (category.isSelected) with(category) {
                        image = R.drawable.ic_category_pets_selected
                        circleColor = R.drawable.ic_circle_primary
                        textColor = R.color.primary
                    } else with(category) {
                        image = R.drawable.ic_category_pets
                        circleColor = R.drawable.ic_circle_whie
                        textColor = R.color.secondary
                    }

                }
            }
        }
        getCategoriesList()
    }


}