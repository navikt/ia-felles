package ia.felles.definisjoner.bransjer

import ia.felles.definisjoner.bransjer.BransjeId.Næring
import ia.felles.definisjoner.bransjer.BransjeId.Næringskoder
import ia.felles.definisjoner.bransjer.StandardNæringer.Companion.barnehagerSN2025
import ia.felles.definisjoner.bransjer.StandardNæringer.Companion.sykehjemSN2025
import ia.felles.definisjoner.bransjer.StandardNæringer.Companion.sykehusSN2025
import ia.felles.definisjoner.bransjer.StandardNæringer.Companion.transportSN2025

enum class BransjeSN2025(
    val navn: String,
    val bransjeId: BransjeId,
) {
    BARNEHAGER(
        navn = "Barnehager",
        bransjeId = Næringskoder(barnehagerSN2025),
    ),
    NÆRINGSMIDDELINDUSTRI(
        navn = "Næringsmiddelindustri",
        bransjeId = Næring("10"),
    ),
    SYKEHUS(
        navn = "Sykehus",
        bransjeId = Næringskoder(sykehusSN2025),
    ),
    SYKEHJEM(
        navn = "Sykehjem",
        bransjeId = Næringskoder(sykehjemSN2025),
    ),
    TRANSPORT(
        navn = "Transport",
        bransjeId = Næringskoder(transportSN2025),
    ),
    BYGG(
        navn = "Bygg",
        bransjeId = Næring("41"),
    ),
    ANLEGG(
        navn = "Anlegg",
        bransjeId = Næring("42"),
    ),
    ;

    companion object {
        fun fra(næringskode: String) = BransjeId.fra(entries, { it.bransjeId }, næringskode)
    }
}
