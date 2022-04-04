package ru.malushko.testtaskforbsm.screenhome.presentation.viewModels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.malushko.testtaskforbsm.screenhome.data.repo.HomeRepoImpl
import ru.malushko.testtaskforbsm.screenhome.domain.usecases.GetCategoriesListUseCase
import ru.malushko.testtaskforbsm.screenhome.domain.usecases.GetHomeStoreListUseCase
import ru.malushko.testtaskforbsm.screenhome.domain.usecases.LoadDataUseCase
import ru.malushko.testtaskforbsm.screenhome.domain.usecases.SelectCategoryUseCase

class HomeViewModel : ViewModel() {

    private val repo = HomeRepoImpl()
    private val getCategoriesListUseCase = GetCategoriesListUseCase(repo)
    private val selectCategoryUseCase = SelectCategoryUseCase(repo)
    private val getHomeStoreListUseCase = GetHomeStoreListUseCase(repo)
    private val loadDataUseCase = LoadDataUseCase(repo)

    val categoriesList = getCategoriesListUseCase()
    val homeStoreList = getHomeStoreListUseCase()

    fun selectCat(id: Int) = selectCategoryUseCase(id)

    init {
        viewModelScope.launch {
            loadDataUseCase()
        }
    }


}