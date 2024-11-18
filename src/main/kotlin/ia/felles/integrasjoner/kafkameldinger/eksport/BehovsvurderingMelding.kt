package ia.felles.integrasjoner.kafkameldinger.eksport

import kotlinx.datetime.LocalDateTime

interface BehovsvurderingMelding {
    val id: String
    val orgnr: String
    val status: String
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
