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
        override val temaer: List<SerializableTema>,
        @Deprecated("Bruk id")
        override val spørreundersøkelseId: String? = null,
        @Deprecated("Bruk temaer")
        override val temaMedSpørsmålOgSvaralternativer: List<TemaMelding>? = null,
    ) : SpørreundersøkelseMelding

    data class SerializableTema(
        override val id: Int,
        override val navn: String,
        override val spørsmål: List<SerializableSpørsmål>,
        @Deprecated("Bruk id")
        override val temaId: Int? = null,
        @Deprecated("Bruk spørsmål")
        override val spørsmålOgSvaralternativer: List<SerializableSpørsmål>? = null,
    ) : TemaMelding

    data class SerializableSpørsmål(
        override val id: String,
        override val tekst: String,
        override val flervalg: Boolean,
        override val svaralternativer: List<SerializableSvaralternativ>,
        @Deprecated("Bruk tekst")
        override val spørsmål: String? = null,
    ) : SpørsmålMelding

    data class SerializableSvaralternativ(
        override val id: String,
        override val tekst: String,
        @Deprecated("Bruk id")
        override val svarId: String? = null,
        @Deprecated("Bruk tekst")
        override val svartekst: String? = null,
    ) : SvaralternativMelding

    private val spørreundersøkelseId = UUID.randomUUID().toString()
    private val svarId = UUID.randomUUID().toString()
    private val temaId = 1
    private val svartekst = "Hverken bra eller dårlig"

    @Test
    fun `Implementasjons data klasser blir ikke null`() {
        val standardSvaralternativ = SerializableSvaralternativ(
            id = svarId,
            tekst = svartekst,
            svarId = svarId,
            svartekst = svartekst,
        )

        val standardSpørsmål = SerializableSpørsmål(
            id = UUID.randomUUID().toString(),
            flervalg = true,
            tekst = "Hva tenker du om IA?",
            spørsmål = "Hva tenker du om IA?",
            svaralternativer = listOf(standardSvaralternativ),
        )

        val standardTema = SerializableTema(
            id = temaId,
            temaId = temaId,
            navn = "Arbeidsmiljø",
            spørsmål = listOf(standardSpørsmål),
            spørsmålOgSvaralternativer = listOf(standardSpørsmål),
        )

        val standardSpørreundersøkelse = SerializableSpørreundersøkelse(
            id = spørreundersøkelseId,
            spørreundersøkelseId = spørreundersøkelseId,
            orgnummer = "123456789",
            virksomhetsNavn = "Bakeriet AS",
            status = SpørreundersøkelseStatus.OPPRETTET,
            type = "behovsvurdering",
            temaer = listOf(standardTema),
            temaMedSpørsmålOgSvaralternativer = listOf(standardTema),
        )
        assertNotNull(standardSpørreundersøkelse)
        assertNotNull(standardTema)
        assertNotNull(standardSpørsmål)
        assertNotNull(standardSvaralternativ)
    }

    @Test
    fun `Nye data klasser blir ikke null`() {
        val nyttSvaralternativ = SerializableSvaralternativ(
            id = svarId,
            tekst = svartekst,
        )

        val nyttSpørsmål = SerializableSpørsmål(
            id = UUID.randomUUID().toString(),
            tekst = "Hva tenker du om IA?",
            flervalg = true,
            svaralternativer = listOf(nyttSvaralternativ),
        )

        val nyttTema = SerializableTema(
            id = temaId,
            navn = "Arbeidsmiljø",
            spørsmål = listOf(nyttSpørsmål),
        )

        val nySpørreundersøkelse = SerializableSpørreundersøkelse(
            id = spørreundersøkelseId,
            orgnummer = "123456789",
            virksomhetsNavn = "Bakeriet AS",
            status = SpørreundersøkelseStatus.OPPRETTET,
            type = "behovsvurdering",
            temaer = listOf(nyttTema),
        )

        assertNotNull(nySpørreundersøkelse)
        assertNotNull(nyttTema)
        assertNotNull(nyttSpørsmål)
        assertNotNull(nyttSvaralternativ)
    }
}
