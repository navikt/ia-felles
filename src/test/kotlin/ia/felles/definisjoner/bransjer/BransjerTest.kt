package ia.felles.definisjoner.bransjer

import org.junit.Test
import kotlin.test.assertTrue

internal class BransjerTest {
    @Test
    fun `alle bransjer har minst én næringskode`() {
        Bransjer.values().forEach { bransje ->
            assertTrue { bransje.næringskoder.isNotEmpty() }
            assertTrue { bransje.navn.isNotBlank() }
        }
    }

    @Test
    fun `alle bransjer er definert med enten 2-sifret eller 5-sifret næringskode`() {
        Bransjer.values().forEach { bransje ->
            bransje.næringskoder.forEach{ næringskode ->
                assertTrue {
                    næringskode.length == 2 || næringskode.length == 5
                }
            }
        }
    }

}
