package ru.malushko.testtaskforbsm.screenhome.domain.usecases

import ru.malushko.testtaskforbsm.screenhome.domain.repo.HomeRepository

class LoadDataUseCase (
    private val homeRepository: HomeRepository
) {
    suspend operator fun invoke() = homeRepository.loadData()
}