package ru.malushko.testtaskforbsm.screenhome.presentation.viewModels


import androidx.lifecycle.ViewModel
import ru.malushko.testtaskforbsm.screenhome.data.repo.HomeRepoImpl
import ru.malushko.testtaskforbsm.screenhome.domain.usecases.GetCategoriesListUseCase
import ru.malushko.testtaskforbsm.screenhome.domain.usecases.SelectCategoryUseCase

class HomeViewModel : ViewModel() {

    private val repo = HomeRepoImpl()
    private val getCategoriesListUseCase = GetCategoriesListUseCase(repo)
    private val selectCategoryUseCase = SelectCategoryUseCase(repo)

    fun selectCat(id: Int) = selectCategoryUseCase(id)
    val categoriesList = getCategoriesListUseCase()


}