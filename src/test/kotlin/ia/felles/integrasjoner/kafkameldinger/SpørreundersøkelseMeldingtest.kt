package ia.felles.integrasjoner.kafkameldinger

import kotlinx.datetime.LocalDate
import org.junit.Test
import java.util.UUID
import kotlin.test.assertNotNull

internal class SpørreundersøkelseMeldingtest {
    data class SerializableSpørreundersøkelse(
        override val spørreundersøkelseId: String,
        override val vertId: String? = null,
        override val orgnummer: String,
        override val virksomhetsNavn: String,
        override val status: SpørreundersøkelseStatus,
        override val type: String? = null,
        override val avslutningsdato: LocalDate? = null,
        override val temaMedSpørsmålOgSvaralternativer: List<SerializableTema>,
    ) : SpørreundersøkelseMelding

    data class SerializableTema(
        override val temaId: Int,
        override val navn: String? = null,
        override val temanavn: Temanavn? = null,
        override val beskrivelse: String? = null,
        override val introtekst: String? = null,
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

    private val standardTemaNy = SerializableTema(
        temaId = 1,
        navn = "Arbeidsmiljø",
        spørsmålOgSvaralternativer = emptyList(),
    )

    private val standardTemaGammel = SerializableTema(
        temaId = 1,
        temanavn = Temanavn.ARBEIDSMILJØ,
        beskrivelse = "Arbeidsmiljø",
        introtekst = "Arbeidsmiljø er viktig for trivsel og produktivitet.",
        spørsmålOgSvaralternativer = emptyList(),
    )

    val nySpørreundersøkelseFormat = SerializableSpørreundersøkelse(
        spørreundersøkelseId = UUID.randomUUID().toString(),
        orgnummer = "123456789",
        virksomhetsNavn = "Bakeriet AS",
        status = SpørreundersøkelseStatus.OPPRETTET,
        temaMedSpørsmålOgSvaralternativer = emptyList(),
    )

    val standardSpørreundersøkelse = SerializableSpørreundersøkelse(
        spørreundersøkelseId = UUID.randomUUID().toString(),
        vertId = UUID.randomUUID().toString(),
        orgnummer = "123456789",
        virksomhetsNavn = "Bakeriet AS",
        status = SpørreundersøkelseStatus.OPPRETTET,
        type = "kartlegging",
        avslutningsdato = LocalDate(1992, 9, 18),
        temaMedSpørsmålOgSvaralternativer = emptyList(),
    )

    @Test
    fun `Implementasjons data klasser blir ikke null`() {
        assertNotNull(standardSpørreundersøkelse)
        assertNotNull(nySpørreundersøkelseFormat)
        assertNotNull(standardTemaGammel)
        assertNotNull(standardTemaNy)
        assertNotNull(standardSpørsmål)
        assertNotNull(standardSvaralternativ)
    }
}
