package ru.malushko.testtaskforbsm.screenhome.presentation.viewModels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.malushko.testtaskforbsm.screenhome.data.repo.HomeRepoImpl
import ru.malushko.testtaskforbsm.screenhome.domain.entities.BestSeller
import ru.malushko.testtaskforbsm.screenhome.domain.usecases.*

class HomeViewModel : ViewModel() {

    private val repo = HomeRepoImpl()
    private val getCategoriesListUseCase = GetCategoriesListUseCase(repo)
    private val selectCategoryUseCase = SelectCategoryUseCase(repo)
    private val getHomeStoreListUseCase = GetHomeStoreListUseCase(repo)
    private val getBestSellerListUseCase = GetBestSellerListUseCase(repo)
    private val loadDataUseCase = LoadDataUseCase(repo)

    val categoriesList = getCategoriesListUseCase()
    val homeStoreList = getHomeStoreListUseCase()
    val bestSellerList = getBestSellerListUseCase()

    fun selectCat(id: Int) = selectCategoryUseCase(id)


    fun onBestSellerFavoriteClick(bestSellerItem: BestSeller){
        bestSellerItem.isFavorites = bestSellerItem.isFavorites != true
    }

    init {
        viewModelScope.launch {
            loadDataUseCase()
        }
    }
}