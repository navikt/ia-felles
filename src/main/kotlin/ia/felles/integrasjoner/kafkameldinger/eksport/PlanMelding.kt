package ia.felles.integrasjoner.kafkameldinger.eksport

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime

@Deprecated("Slutt å ta i bruk interfaces for kafka meldingsvalidering til bigquery")
interface PlanMelding {
    val id: String
    val samarbeidId: Int
    val sistEndret: LocalDateTime
    val temaer: List<TemaMelding>
}

@Deprecated("Slutt å ta i bruk interfaces for kafka meldingsvalidering til bigquery")
interface TemaMelding {
    val id: Int
    val navn: String
    val inkludert: Boolean
    val innhold: List<InnholdMelding>
}

@Deprecated("Slutt å ta i bruk interfaces for kafka meldingsvalidering til bigquery")
interface InnholdMelding {
    val id: Int
    val navn: String
    val inkludert: Boolean
    val status: InnholdStatus?
    val startDato: LocalDate?
    val sluttDato: LocalDate?
}

@Deprecated("Slutt å ta i bruk interfaces for kafka meldingsvalidering til bigquery")
enum class InnholdStatus {
    PLANLAGT,
    PÅGÅR,
    FULLFØRT,
    AVBRUTT,
}
