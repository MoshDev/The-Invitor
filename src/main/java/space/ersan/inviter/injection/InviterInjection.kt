package space.ersan.inviter.injection

import dagger.Component
import dagger.Module
import dagger.Provides
import space.ersan.inviter.domain.*
import space.ersan.inviter.model.InviterRepository
import space.ersan.inviter.model.DefaultInviterRepository
import space.ersan.inviter.presenter.*
import javax.inject.Scope

@Scope
annotation class InviterScope


@InviterScope
@Component(modules = [InviterModule::class])
interface InviterComponent {
    fun inject(inviterBinder: DefaultInviterBinder)
}

@Module
class InviterModule {


    @InviterScope
    @Provides
    fun provideView(): InviterView = DefaultInviterView()

    @InviterScope
    @Provides
    fun provideViewModel(inviterInteractor: InviterInteractor)
            : InviterViewModel = DefaultInviterViewModel(inviterInteractor)

    @InviterScope
    @Provides
    fun provideRepository(): InviterRepository = DefaultInviterRepository("/customers.txt")

    @InviterScope
    @Provides
    fun provideCustomersByDistanceUseCase(customerRepository: InviterRepository)
            : CustomersByDistanceUseCase = DefaultCustomersByDistanceUseCase(customerRepository)

    @InviterScope
    @Provides
    fun officeLocationUseCase(customerRepository: InviterRepository)
            : OfficeLocationUseCase = DefaultOfficeLocationUseCase(customerRepository)

    @InviterScope
    @Provides
    fun inviterInteractor(customersByDistanceUseCase: CustomersByDistanceUseCase, officeLocationUseCase: OfficeLocationUseCase)
            : InviterInteractor = DefaultInviterInteractor(customersByDistanceUseCase, officeLocationUseCase)

}


