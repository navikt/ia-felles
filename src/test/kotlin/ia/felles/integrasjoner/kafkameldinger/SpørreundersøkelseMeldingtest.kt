package ia.felles.integrasjoner.kafkameldinger

import java.util.UUID
import kotlin.test.assertNotNull
import kotlinx.datetime.LocalDate
import org.junit.Test

internal class SpørreundersøkelseMeldingtest {

    data class SpørreundersøkelseImplementasjon(
        override val id: String,
        override val vertId: String? = null,
        override val orgnummer: String,
        override val virksomhetsNavn: String,
        override val status: SpørreundersøkelseStatus,
        override val type: String,
        override val avslutningsdato: LocalDate,
        override val temaMedSpørsmålOgSvaralternativer: List<TemaImplementasjon>,
    ) : SpørreundersøkelseMelding

    data class TemaImplementasjon(
        override val id: Int,
        override val navn: String? = null,
        override val temanavn: Temanavn? = null,
        override val beskrivelse: String? = null,
        override val introtekst: String? = null,
        override val spørsmålOgSvaralternativer: List<SpørsmålImplementasjon>,
    ) : TemaMelding

    data class SpørsmålImplementasjon(
        override val id: String,
        override val spørsmål: String,
        override val flervalg: Boolean,
        override val svaralternativer: List<SvaralternativImplementasjon>,
    ) : SpørsmålMelding

    data class SvaralternativImplementasjon(
        override val id: String,
        override val svartekst: String,
    ) : SvaralternativMelding

    private val standardSvaralternativ = SvaralternativImplementasjon(
        id = UUID.randomUUID().toString(),
        svartekst = "Hverken bra eller dårlig"
    )

    private val standardSpørsmål = SpørsmålImplementasjon(
        flervalg = true,
        id = UUID.randomUUID().toString(),
        spørsmål = "Hva tenker du om IA?",
        svaralternativer = emptyList(),
    )

    private val standardTemaNy = TemaImplementasjon(
        id = 1,
        navn = "Arbeidsmiljø",
        spørsmålOgSvaralternativer = emptyList()
    )

    private val standardTemaGammel = TemaImplementasjon(
        id = 1,
        temanavn = Temanavn.ARBEIDSMILJØ,
        beskrivelse = "Arbeidsmiljø",
        introtekst = "Arbeidsmiljø er viktig for trivsel og produktivitet.",
        spørsmålOgSvaralternativer = emptyList()
    )

    val standardSpørreundersøkelseUtenVertId = SpørreundersøkelseImplementasjon(
        id = UUID.randomUUID().toString(),
        orgnummer = "123456789",
        virksomhetsNavn = "Bakeriet AS",
        status = SpørreundersøkelseStatus.OPPRETTET,
        type = "kartlegging",
        avslutningsdato = LocalDate(1992, 9, 18),
        temaMedSpørsmålOgSvaralternativer = emptyList()
    )

    val standardSpørreundersøkelse = SpørreundersøkelseImplementasjon(
        id = UUID.randomUUID().toString(),
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
        assertNotNull(standardSpørreundersøkelseUtenVertId)
        assertNotNull(standardTemaGammel)
        assertNotNull(standardTemaNy)
        assertNotNull(standardSpørsmål)
        assertNotNull(standardSvaralternativ)
    }
}