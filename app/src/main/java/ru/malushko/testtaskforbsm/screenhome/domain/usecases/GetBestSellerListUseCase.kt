package ru.malushko.testtaskforbsm.screenhome.domain.usecases

import ru.malushko.testtaskforbsm.screenhome.domain.repo.HomeRepository

class GetBestSellerListUseCase(
    private val homeRepository: HomeRepository
) {
    operator fun invoke() = homeRepository.getBestSellerList()
}