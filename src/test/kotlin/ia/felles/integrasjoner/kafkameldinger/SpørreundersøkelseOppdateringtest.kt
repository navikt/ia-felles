package ia.felles.integrasjoner.kafkameldinger

import ia.felles.integrasjoner.kafkameldinger.oppdatering.SpørsmålResultatMelding
import ia.felles.integrasjoner.kafkameldinger.oppdatering.SvarResultatMelding
import ia.felles.integrasjoner.kafkameldinger.oppdatering.TemaResultatMelding
import org.junit.Test
import java.util.UUID
import kotlin.test.assertNotNull

internal class SpørreundersøkelseOppdateringtest {
    data class TemaResultatDto(
        override val id: Int,
        @Deprecated("Bruk Id")
        override val temaId: Int,
        override val navn: String,
        override val spørsmålMedSvar: List<SpørsmålResultatDto>,
    ) : TemaResultatMelding

    data class SpørsmålResultatDto(
        override val id: String,
        @Deprecated("Bruk id")
        override val spørsmålId: String,
        override val tekst: String,
        override val flervalg: Boolean,
        override val svarListe: List<SvarResultatDto>,
    ) : SpørsmålResultatMelding

    data class SvarResultatDto(
        override val id: String,
        @Deprecated("Bruk id")
        override val svarId: String,
        override val tekst: String,
        override val antallSvar: Int,
    ) : SvarResultatMelding

    private val svarId = UUID.randomUUID().toString()
    private val spørsmålId = UUID.randomUUID().toString()
    private val temaId = 1

    private val svar = SvarResultatDto(
        id = svarId,
        svarId = svarId,
        tekst = "Hverken bra eller dårlig",
        antallSvar = 10,
    )

    private val spørsmål = SpørsmålResultatDto(
        id = spørsmålId,
        spørsmålId = spørsmålId,
        tekst = "Hva tenker du om IA?",
        flervalg = true,
        svarListe = listOf(svar),
    )

    private val tema = TemaResultatDto(
        id = temaId,
        temaId = temaId,
        navn = "Arbeidsmiljø",
        spørsmålMedSvar = listOf(spørsmål),
    )

    @Test
    fun `Implementasjons data klasser blir ikke null`() {
        assertNotNull(tema)
        assertNotNull(spørsmål)
        assertNotNull(svar)
    }
}
