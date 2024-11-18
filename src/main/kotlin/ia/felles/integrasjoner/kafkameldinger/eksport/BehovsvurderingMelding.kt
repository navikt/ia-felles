package ia.felles.integrasjoner.kafkameldinger.eksport

import kotlinx.datetime.LocalDateTime

interface BehovsvurderingMelding {
    val id: String
    val orgnr: String
    val saksnummer: String
    val status: String
    val opprettetAv: String
    val opprettet: LocalDateTime
    val endret: LocalDateTime
    val påbegynt: LocalDateTime
    val fullført: LocalDateTime
    val samarbeidId: Int
    val harMinstEttSvar: Boolean
    val førsteSvarMotatt: LocalDateTime?
    val sisteSvarMottatt: LocalDateTime?
}
