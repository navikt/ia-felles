package ia.felles.definisjoner.bransjer

// SN2007
val barnehagerSN2007: List<String> = listOf("88911")
val sykehusSN2007: List<String> = listOf("86101", "86102", "86104", "86105", "86106", "86107")
val sykehjemSN2007: List<String> = listOf("87101", "87102")
val transportSN2007: List<String> = listOf("49100", "49311", "49312", "49391", "49392")

// SN2025
val barnehagerSN2025: List<String> = listOf("85100")
val sykehusSN2025: List<String> = listOf("86101", "86102", "86103", "86104")
val sykehjemSN2025: List<String> = listOf("87101", "87102", "87103", "87104", "87105", "87106")
val transportSN2025: List<String> = listOf("49110", "49120", "49310", "49320", "49330", "49340", "49390")

/*

Definisjonen av bransjer er hentet fra arbeidsmiljøportalen:

*/

enum class Bransje(
    val navn: String,
    val bransjeId: BransjeId,
) {
    BARNEHAGER(
        navn = "Barnehager",
        bransjeId = BransjeId.Næringskoder((barnehagerSN2007 union barnehagerSN2025).toList()),
    ),
    NÆRINGSMIDDELINDUSTRI(
        navn = "Næringsmiddelindustri",
        bransjeId = BransjeId.Næring("10"),
    ),
    SYKEHUS(
        navn = "Sykehus",
        bransjeId = BransjeId.Næringskoder((sykehusSN2007 union sykehusSN2025).toList()),
    ),
    SYKEHJEM(
        navn = "Sykehjem",
        bransjeId = BransjeId.Næringskoder((sykehjemSN2007 union sykehjemSN2025).toList()),
    ),
    TRANSPORT(
        navn = "Transport",
        bransjeId = BransjeId.Næringskoder((transportSN2007 union transportSN2025).toList()),
    ),
    BYGG(
        navn = "Bygg",
        bransjeId = BransjeId.Næring("41"),
    ),
    ANLEGG(
        navn = "Anlegg",
        bransjeId = BransjeId.Næring("42"),
    ),
    ;

    companion object {
        fun fra(næringskode: String) =
            Bransje.entries.firstOrNull {
                val næringskodeUtenPunktum = næringskode.replace(".", "")

                when (it.bransjeId) {
                    is BransjeId.Næring -> it.bransjeId.næring == næringskodeUtenPunktum.take(2)
                    is BransjeId.Næringskoder -> it.bransjeId.næringskoder.contains(næringskodeUtenPunktum)
                }
            }
    }
}
