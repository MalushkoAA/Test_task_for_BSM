package ru.malushko.testtaskforbsm.screenhome.domain.usecases

import ru.malushko.testtaskforbsm.screenhome.domain.entities.Category
import ru.malushko.testtaskforbsm.screenhome.domain.repo.HomeRepository

class SelectCategoryUseCase(
    private val homeRepository: HomeRepository
) {
    operator fun invoke(category: Category) = homeRepository.selectCategory(category)
}