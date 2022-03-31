package ru.malushko.testtaskforbsm.screenhome.domain.usecases

import ru.malushko.testtaskforbsm.screenhome.domain.repo.HomeRepository

class GetHomeStoreListUseCase(
    private val homeRepository: HomeRepository
) {
    operator fun invoke() = homeRepository.getHomeStoreList()
}