package ia.felles.integrasjoner.kafkameldinger

import kotlinx.datetime.LocalDate

interface SpørreundersøkelseMelding{
    val spørreundersøkelseId: String
    val vertId: String?
    val orgnummer: String
    val virksomhetsNavn: String
    val status: SpørreundersøkelseStatus
    val type: String
    val avslutningsdato: LocalDate
    val temaMedSpørsmålOgSvaralternativer: List<TemaMelding>
}
