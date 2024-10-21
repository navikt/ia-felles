package ia.felles.integrasjoner.kafkameldinger

import org.junit.Test
import java.util.UUID
import kotlin.test.assertNotNull

internal class SpørreundersøkelseMeldingtest {
    data class SerializableSpørreundersøkelse(
        override val spørreundersøkelseId: String,
        override val orgnummer: String,
        override val virksomhetsNavn: String,
        override val status: SpørreundersøkelseStatus,
        override val type: String,
        override val temaMedSpørsmålOgSvaralternativer: List<SerializableTema>,
    ) : SpørreundersøkelseMelding

    data class SerializableTema(
        override val temaId: Int,
        override val navn: String,
        override val spørsmålOgSvaralternativer: List<SerializableSpørsmål>,
    ) : TemaMelding

    data class SerializableSpørsmål(
        override val id: String,
        override val spørsmål: String,
        override val flervalg: Boolean,
        override val svaralternativer: List<SerializableSvaralternativ>,
    ) : SpørsmålMelding

    data class SerializableSvaralternativ(
        override val svarId: String,
        override val svartekst: String,
    ) : SvaralternativMelding

    private val standardSvaralternativ = SerializableSvaralternativ(
        svarId = UUID.randomUUID().toString(),
        svartekst = "Hverken bra eller dårlig",
    )

    private val standardSpørsmål = SerializableSpørsmål(
        flervalg = true,
        id = UUID.randomUUID().toString(),
        spørsmål = "Hva tenker du om IA?",
        svaralternativer = emptyList(),
    )

    private val standardTema = SerializableTema(
        temaId = 1,
        navn = "Arbeidsmiljø",
        spørsmålOgSvaralternativer = emptyList(),
    )

    val standardSpørreundersøkelse = SerializableSpørreundersøkelse(
        spørreundersøkelseId = UUID.randomUUID().toString(),
        orgnummer = "123456789",
        virksomhetsNavn = "Bakeriet AS",
        status = SpørreundersøkelseStatus.OPPRETTET,
        type = "behovsvurdering",
        temaMedSpørsmålOgSvaralternativer = emptyList(),
    )

    @Test
    fun `Implementasjons data klasser blir ikke null`() {
        assertNotNull(standardSpørreundersøkelse)
        assertNotNull(standardTema)
        assertNotNull(standardSpørsmål)
        assertNotNull(standardSvaralternativ)
    }
}
