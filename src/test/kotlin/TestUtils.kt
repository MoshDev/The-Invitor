import org.mockito.ArgumentCaptor
import org.mockito.Mockito
import org.mockito.stubbing.OngoingStubbing


inline fun <reified T : Any> mock(): T = Mockito.mock(T::class.java)
inline fun <reified T : Any> mock(body: T.() -> Unit): T = Mockito.mock(T::class.java).apply(body)

inline fun <reified T : Any> onMethod(methodToCall: T): OngoingStubbing<T> = Mockito.`when`(methodToCall)

inline fun <reified T : Any> argumentCaptor(): ArgumentCaptor<T> = ArgumentCaptor.forClass(T::class.java)

inline fun <reified T> any(): T = Mockito.any<T>()

fun <T> captureKt(argumentCaptor: ArgumentCaptor<T>): T = argumentCaptor.capture()

fun <T> eqKt(obj: T): T = Mockito.eq<T>(obj)