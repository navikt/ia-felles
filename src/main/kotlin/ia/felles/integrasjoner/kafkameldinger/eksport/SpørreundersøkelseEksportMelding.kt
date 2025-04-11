package ia.felles.integrasjoner.kafkameldinger.eksport

import ia.felles.integrasjoner.kafkameldinger.spørreundersøkelse.SpørreundersøkelseStatus
import kotlinx.datetime.LocalDateTime

@Deprecated("Slutt å ta i bruk interfaces for kafka meldingsvalidering til bigquery")
interface SpørreundersøkelseEksportMelding {
    val id: String
    val orgnr: String
    val type: String
    val status: SpørreundersøkelseStatus
    val samarbeidId: Int
    val saksnummer: String
    val opprettetAv: String
    val opprettet: LocalDateTime
    val harMinstEttSvar: Boolean
    val påbegynt: LocalDateTime?
    val fullført: LocalDateTime?
    val endret: LocalDateTime?
    val førsteSvarMotatt: LocalDateTime?
    val sisteSvarMottatt: LocalDateTime?
}
