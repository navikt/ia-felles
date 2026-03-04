package ia.felles.definisjoner.noa

import ia.felles.definisjoner.bransjer.BransjeId

val BARNEHAGE_OG_SFO_SN2025: List<String> = listOf(
    "85100",
    "88910",
)
val SYKEHJEM_OMSORGSINSTITUSJONER_SN2025: List<String> = listOf(
    "87101",
    "87102",
    "87104",
    "87105",
    "87106",
    "87201",
    "87202",
    "87300",
    "87991",
    "87999",
)
val NÆRINGSMIDDELINDUSTRI_SN2025: List<String> = listOf(
    "10110",
    "10120",
    "10130",
    "10201",
    "10202",
    "10203",
    "10310",
    "10320",
    "10390",
    "10410",
    "10420",
    "10510",
    "10520",
    "10610",
    "10620",
    "10710",
    "10720",
    "10730",
    "10810",
    "10820",
    "10830",
    "10840",
    "10850",
    "10860",
    "10890",
    "10911",
    "10912",
    "10920",
    "11010",
    "11020",
    "11030",
    "11040",
    "11050",
    "11060",
    "11070",
    "12000",
)

enum class NoaNæring(
    val navn: String,
    val bransjeId: BransjeId.Næringskoder,
) {
    BARNEHAGE_OG_SFO(
        navn = "Barnehage og SFO",
        bransjeId = BransjeId.Næringskoder(BARNEHAGE_OG_SFO_SN2025),
    ),
    SYKEHJEM_OMSORGSINSTITUSJONER(
        navn = "Sykehjem/omsorgsinst.",
        bransjeId = BransjeId.Næringskoder(SYKEHJEM_OMSORGSINSTITUSJONER_SN2025),
    ),
    NÆRINGSMIDDELINDUSTRI(
        navn = "Næringsmiddelindustri",
        bransjeId = BransjeId.Næringskoder(NÆRINGSMIDDELINDUSTRI_SN2025),
    ),
    ;

    companion object {
        fun fra(næringskodeSN2025: String) =
            NoaNæring.entries.firstOrNull {
                val næringskodeUtenPunktum = næringskodeSN2025.replace(".", "")

                when (it.bransjeId) {
                    is BransjeId.Næringskoder -> it.bransjeId.næringskoder.contains(næringskodeUtenPunktum)
                }
            }
    }
}
