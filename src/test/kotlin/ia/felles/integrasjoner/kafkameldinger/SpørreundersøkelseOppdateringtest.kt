package ia.felles.integrasjoner.kafkameldinger

import ia.felles.integrasjoner.kafkameldinger.oppdatering.SpørsmålResultatMelding
import ia.felles.integrasjoner.kafkameldinger.oppdatering.SvarResultatMelding
import ia.felles.integrasjoner.kafkameldinger.oppdatering.TemaResultatMelding
import org.junit.Test
import java.util.UUID
import kotlin.test.assertNotNull

internal class SpørreundersøkelseOppdateringtest {
    data class TemaResultatDto(
        override val temaId: Int,
        override val navn: String,
        override val spørsmålMedSvar: List<SpørsmålResultatDto>,
    ) : TemaResultatMelding

    data class SpørsmålResultatDto(
        override val spørsmålId: String,
        override val tekst: String,
        override val flervalg: Boolean,
        override val svarListe: List<SvarResultatDto>,
    ) : SpørsmålResultatMelding

    data class SvarResultatDto(
        override val svarId: String,
        override val tekst: String,
        override val antallSvar: Int,
    ) : SvarResultatMelding

    private val svar = SvarResultatDto(
        svarId = UUID.randomUUID().toString(),
        tekst = "Hverken bra eller dårlig",
        antallSvar = 10,
    )

    private val spørsmål = SpørsmålResultatDto(
        flervalg = true,
        spørsmålId = UUID.randomUUID().toString(),
        tekst = "Hva tenker du om IA?",
        svarListe = listOf(svar),
    )

    private val tema = TemaResultatDto(
        temaId = 1,
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
