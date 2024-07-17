package ia.felles.integrasjoner.kafkameldinger

import ia.felles.integrasjoner.kafkameldinger.oppdatering.SpørsmålResultatMelding
import ia.felles.integrasjoner.kafkameldinger.oppdatering.SvarResultatMelding
import ia.felles.integrasjoner.kafkameldinger.oppdatering.TemaResultatMelding
import java.util.UUID
import kotlin.test.assertNotNull
import org.junit.Test

internal class SpørreundersøkelseOppdateringtest {

    data class TemaResultatDto(
        override val temaId: Int,
        override val navn: String?,
        override val spørsmålMedSvar: List<SpørsmålResultatDto>,
        override val beskrivelse: String?,
        override val tema: String?
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
        antallSvar = 10
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
        beskrivelse = null,
        tema = null
    )

    private val gammelTTema = TemaResultatDto(
        temaId = 1,
        navn = null,
        spørsmålMedSvar = listOf(spørsmål),
        beskrivelse = "Arbeidsmiljø",
        tema = Temanavn.ARBEIDSMILJØ.name
    )

    @Test
    fun `Implementasjons data klasser blir ikke null`() {
        assertNotNull(gammelTTema)
        assertNotNull(tema)
        assertNotNull(spørsmål)
        assertNotNull(svar)
    }
}