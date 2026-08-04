package ia.felles.definisjoner.bransjer

import ia.felles.definisjoner.bransjer.BransjeId.Næring
import ia.felles.definisjoner.bransjer.BransjeId.Næringskoder
import ia.felles.definisjoner.bransjer.StandardNæringer.Companion.barnehagerSN2007
import ia.felles.definisjoner.bransjer.StandardNæringer.Companion.sykehjemSN2007
import ia.felles.definisjoner.bransjer.StandardNæringer.Companion.sykehusSN2007
import ia.felles.definisjoner.bransjer.StandardNæringer.Companion.transportSN2007

enum class BransjeSN2007(
    val navn: String,
    val bransjeId: BransjeId,
) {
    BARNEHAGER(
        navn = "Barnehager",
        bransjeId = Næringskoder(barnehagerSN2007),
    ),
    NÆRINGSMIDDELINDUSTRI(
        navn = "Næringsmiddelindustri",
        bransjeId = Næring("10"),
    ),
    SYKEHUS(
        navn = "Sykehus",
        bransjeId = Næringskoder(sykehusSN2007),
    ),
    SYKEHJEM(
        navn = "Sykehjem",
        bransjeId = Næringskoder(sykehjemSN2007),
    ),
    TRANSPORT(
        navn = "Transport",
        bransjeId = Næringskoder(transportSN2007),
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
