package ia.felles.integrasjoner.kafkameldinger.eksport

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime

interface PlanMelding {
    val id: String
    val samarbeidId: Int
    val sistEndret: LocalDateTime
    val temaer: List<TemaMelding>
}

interface TemaMelding {
    val id: Int
    val navn: String
    val inkludert: Boolean
    val innhold: List<InnholdMelding>
}

interface InnholdMelding {
    val id: Int
    val navn: String
    val inkludert: Boolean
    val status: InnholdStatus?
    val startDato: LocalDate?
    val sluttDato: LocalDate?
}

enum class InnholdStatus {
    PLANLAGT,
    PÅGÅR,
    FULLFØRT,
    AVBRUTT,
}
