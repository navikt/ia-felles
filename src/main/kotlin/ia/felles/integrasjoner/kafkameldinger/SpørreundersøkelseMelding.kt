package ia.felles.integrasjoner.kafkameldinger

import kotlinx.datetime.LocalDate

interface SpørreundersøkelseMelding{
    val spørreundersøkelseId: String
    val vertId: String? //TODO: Deprecate
    val orgnummer: String
    val virksomhetsNavn: String
    val status: SpørreundersøkelseStatus
    val type: String? //TODO: Deprecate
    val avslutningsdato: LocalDate? //TODO: Deprecate
    val temaMedSpørsmålOgSvaralternativer: List<TemaMelding>
}
