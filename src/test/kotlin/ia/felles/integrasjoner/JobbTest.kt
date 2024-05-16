package ia.felles.integrasjoner

import java.time.Clock
import kotlin.test.assertNotNull
import org.junit.Test

internal class JobbTest {

    data class JobbInfoImplementasjon(
        override val jobb: Jobb,
        override val tidspunkt: String,
        override val applikasjon: String,
    ) : JobbInfo

    @Test
    fun `JobbInfoImplementasjon blir ikke null`() {
        Jobb.entries.forEach { jobbtype ->
            val nyJobbInfo = JobbInfoImplementasjon(
                jobb = jobbtype,
                tidspunkt = "${Clock.systemUTC().instant()}",
                applikasjon = "jobbsender"
            )
            assertNotNull(nyJobbInfo)
        }
    }
}