package ru.malushko.testtaskforbsm.screenhome.domain.repo

import androidx.lifecycle.LiveData
import ru.malushko.testtaskforbsm.screenhome.domain.entities.BestSeller
import ru.malushko.testtaskforbsm.screenhome.domain.entities.Category
import ru.malushko.testtaskforbsm.screenhome.domain.entities.HomeStore

interface HomeRepository {

    fun getCategoriesList(): LiveData<List<Category>>

    fun selectCategory(category: Category)

    fun getHomeStoreList(): LiveData<List<HomeStore>>

    fun getBestSellerList(): LiveData<List<BestSeller>>

    fun getBestSeller(id: Int): LiveData<BestSeller>

    suspend fun loadData()

}