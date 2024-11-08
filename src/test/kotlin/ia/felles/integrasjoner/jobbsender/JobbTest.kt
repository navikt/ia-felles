package ia.felles.integrasjoner.jobbsender

import org.junit.Test
import java.time.Clock
import kotlin.test.assertNotNull

internal class JobbTest {
    data class JobbInfoImplementasjon(
        override val jobb: Jobb,
        override val tidspunkt: String,
        override val parameter: String?,
        override val applikasjon: String,
    ) : JobbInfo

    @Test
    fun `Bruk alle verdier i Jobb for å unngå warnings`() {
        Jobb.entries.forEach { jobbtype ->
            val nyJobbInfo = JobbInfoImplementasjon(
                jobb = jobbtype,
                tidspunkt = "${Clock.systemUTC().instant()}",
                parameter = null,
                applikasjon = "jobbsender",
            )
            assertNotNull(nyJobbInfo)
        }
    }
}
