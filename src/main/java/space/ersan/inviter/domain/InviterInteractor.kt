package space.ersan.inviter.domain

interface InviterInteractor : CustomersByDistanceUseCase, OfficeLocationUseCase

class DefaultInviterInteractor(customersByDistanceUseCase: CustomersByDistanceUseCase,
                               officeLocationUseCase: OfficeLocationUseCase) :
        InviterInteractor,
        CustomersByDistanceUseCase by customersByDistanceUseCase,
        OfficeLocationUseCase by officeLocationUseCase