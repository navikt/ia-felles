package ia.felles.definisjoner.bransjer

import org.junit.Test
import kotlin.test.assertTrue

internal class BransjeTest {
    @Test
    fun `alle bransjer har navn og gyldig id`() {
        Bransje.values().forEach { bransje ->
            assertTrue(bransje.navn.isNotBlank())
            assertTrue {
                when (bransje.bransjeId) {
                    // Main og test er satt opp som separate moduler, så smart cast fungerer ikke
                    is BransjeId.Næring -> (bransje.bransjeId as BransjeId.Næring).næring.matches(Regex("""\d{2}"""))
                    is BransjeId.Næringskoder -> (bransje.bransjeId as BransjeId.Næringskoder).næringskoder.all { it.matches(Regex("""\d{5}""")) }
                }
            }
        }
    }
}
