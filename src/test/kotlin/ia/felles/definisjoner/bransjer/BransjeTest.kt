package ia.felles.definisjoner.bransjer

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

internal class BransjeTest {
    @Test
    fun `alle bransjer har navn og gyldig id`() {
        Bransje.entries.forEach { bransje ->
            assertTrue(bransje.navn.isNotBlank())
            assertTrue {
                when (bransje.bransjeId) {
                    // Main og test er satt opp som separate moduler, så smart cast fungerer ikke
                    is BransjeId.Næring -> bransje.bransjeId.næring.matches(Regex("""\d{2}"""))
                    is BransjeId.Næringskoder -> bransje.bransjeId.næringskoder.all {
                        it.matches(
                            Regex("""\d{5}"""),
                        )
                    }
                }
            }
        }
    }

    @Test
    fun `uthenting av bransje basert på næring henter riktig bransje`() {
        assertEquals(Bransje.fra("10"), Bransje.NÆRINGSMIDDELINDUSTRI)
    }

    @Test
    fun `uthenting av bransje basert på næringskode henter riktig bransje`() {
        assertEquals(Bransje.fra("87101"), Bransje.SYKEHJEM)
    }

    @Test
    fun `utledder bransje basert på næringskode med eller uten punktum`() {
        assertEquals(Bransje.fra("49311"), Bransje.TRANSPORT)
        assertEquals(Bransje.fra("49.311"), Bransje.TRANSPORT)
        assertNull(Bransje.fra("49_311"))
    }
}
