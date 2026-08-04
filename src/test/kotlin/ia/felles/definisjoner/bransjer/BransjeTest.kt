package ia.felles.definisjoner.bransjer

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

internal class BransjeTest {
    @Test
    fun `alle bransjer har navn og gyldig id`() {
        Bransje.entries.forEach { assertHarNavnOgGyldigId(it.navn, it.bransjeId) }
        BransjeSN2007.entries.forEach { assertHarNavnOgGyldigId(it.navn, it.bransjeId) }
        BransjeSN2025.entries.forEach { assertHarNavnOgGyldigId(it.navn, it.bransjeId) }
    }

    @Test
    fun `uthenting av bransje basert på næring henter riktig bransje`() {
        assertEquals(Bransje.fra("10"), Bransje.NÆRINGSMIDDELINDUSTRI)
        assertEquals(BransjeSN2007.fra("10"), BransjeSN2007.NÆRINGSMIDDELINDUSTRI)
        assertEquals(BransjeSN2025.fra("10"), BransjeSN2025.NÆRINGSMIDDELINDUSTRI)
    }

    @Test
    fun `uthenting av bransje basert på næringskode henter riktig bransje`() {
        assertEquals(Bransje.fra("87101"), Bransje.SYKEHJEM)
        assertEquals(Bransje.fra("87103"), Bransje.SYKEHJEM)
        assertEquals(BransjeSN2007.fra("87101"), BransjeSN2007.SYKEHJEM)
        assertEquals(BransjeSN2025.fra("87101"), BransjeSN2025.SYKEHJEM)
        assertEquals(BransjeSN2025.fra("87103"), BransjeSN2025.SYKEHJEM)
    }

    @Test
    fun `uthenting av bransje basert på næringskode henter riktig bransje for SN2007 eller SN2025`() {
        assertEquals(Bransje.fra("88911"), Bransje.BARNEHAGER)
        assertEquals(Bransje.fra("85100"), Bransje.BARNEHAGER)
        assertEquals(BransjeSN2007.fra("88911"), BransjeSN2007.BARNEHAGER)
        assertNull(BransjeSN2025.fra("88911"))
        assertEquals(BransjeSN2025.fra("85100"), BransjeSN2025.BARNEHAGER)
        assertNull(BransjeSN2007.fra("85100"))
    }

    @Test
    fun `utledder bransje basert på næringskode med eller uten punktum`() {
        assertEquals(Bransje.fra("49311"), Bransje.TRANSPORT)
        assertEquals(Bransje.fra("49.311"), Bransje.TRANSPORT)
        assertNull(Bransje.fra("49_311"))
    }

    private fun assertHarNavnOgGyldigId(navn: String, bransjeId: BransjeId) {
        assertTrue(navn.isNotBlank())
        assertTrue {
            when (val id = bransjeId) {
                is BransjeId.Næring -> id.næring.matches(Regex("""\d{2}"""))
                is BransjeId.Næringskoder -> id.næringskoder.all { it.matches(Regex("""\d{5}""")) }
            }
        }
    }
}
