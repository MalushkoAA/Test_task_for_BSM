package ru.malushko.testtaskforbsm.screenhome.domain.usecases

import ru.malushko.testtaskforbsm.screenhome.domain.repo.HomeRepository

class SelectCategoryUseCase(
    private val homeRepository: HomeRepository
) {
    operator fun invoke(id: Int) = homeRepository.selectCategory(id)
}