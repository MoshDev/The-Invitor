package space.ersan.inviter.domain

import space.ersan.inviter.model.InviterRepository
import space.ersan.inviter.model.Location

interface OfficeLocationUseCase {
    fun getOfficeLocation(): Location
}

class DefaultOfficeLocationUseCase(private val customerRepository: InviterRepository) : OfficeLocationUseCase {

    override fun getOfficeLocation() = customerRepository.getOfficeLocation()
}