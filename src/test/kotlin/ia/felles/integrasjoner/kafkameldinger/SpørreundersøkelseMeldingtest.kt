package ia.felles.integrasjoner.kafkameldinger

import ia.felles.integrasjoner.kafkameldinger.spørreundersøkelse.SpørreundersøkelseMelding
import ia.felles.integrasjoner.kafkameldinger.spørreundersøkelse.SpørreundersøkelseStatus
import ia.felles.integrasjoner.kafkameldinger.spørreundersøkelse.SpørsmålMelding
import ia.felles.integrasjoner.kafkameldinger.spørreundersøkelse.SvaralternativMelding
import ia.felles.integrasjoner.kafkameldinger.spørreundersøkelse.TemaMelding
import org.junit.Test
import java.util.UUID
import kotlin.test.assertNotNull

internal class SpørreundersøkelseMeldingtest {
    data class SerializableSpørreundersøkelse(
        override val id: String,
        override val type: String,
        override val status: SpørreundersøkelseStatus,
        override val orgnummer: String,
        override val virksomhetsNavn: String,
        override val samarbeidsNavn: String,
        override val temaer: List<SerializableTema>,
    ) : SpørreundersøkelseMelding

    data class SerializableTema(
        override val id: Int,
        override val navn: String,
        override val spørsmål: List<SerializableSpørsmål>,
    ) : TemaMelding

    data class SerializableSpørsmål(
        override val id: String,
        override val tekst: String,
        override val flervalg: Boolean,
        override val svaralternativer: List<SerializableSvaralternativ>,
    ) : SpørsmålMelding

    data class SerializableSvaralternativ(
        override val id: String,
        override val tekst: String,
    ) : SvaralternativMelding

    private val spørreundersøkelseId = UUID.randomUUID().toString()
    private val temaId = 1
    private val spørsmålId = UUID.randomUUID().toString()
    private val svarId = UUID.randomUUID().toString()
    private val svartekst = "Hverken bra eller dårlig"

    @Test
    fun `Implementasjons data klasser blir ikke null`() {
        val standardSvaralternativ = SerializableSvaralternativ(
            id = svarId,
            tekst = svartekst,
        )

        val standardSpørsmål = SerializableSpørsmål(
            id = spørsmålId,
            flervalg = true,
            tekst = "Hva tenker du om IA?",
            svaralternativer = listOf(standardSvaralternativ),
        )

        val standardTema = SerializableTema(
            id = temaId,
            navn = "Arbeidsmiljø",
            spørsmål = listOf(standardSpørsmål),
        )

        val standardSpørreundersøkelse = SerializableSpørreundersøkelse(
            id = spørreundersøkelseId,
            orgnummer = "123456789",
            virksomhetsNavn = "Bakeriet AS",
            samarbeidsNavn = "Samarbeid uten navn",
            status = SpørreundersøkelseStatus.OPPRETTET,
            type = "behovsvurdering",
            temaer = listOf(standardTema),
        )
        assertNotNull(standardSpørreundersøkelse)
        assertNotNull(standardTema)
        assertNotNull(standardSpørsmål)
        assertNotNull(standardSvaralternativ)
    }
}
