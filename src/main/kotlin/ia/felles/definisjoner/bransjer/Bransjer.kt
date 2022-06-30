package ia.felles.definisjoner.bransjer

/*

Definisjonen av bransjer er hentet fra arbeidsmiljøportalen:

*/

enum class Bransjer(val navn: String, val næringskoder: List<String>) {
    BARNEHAGER(
        navn = "Barnehager",
        næringskoder = listOf("88911")
    ),
    NÆRINGSMIDDELINDUSTRI(
        navn = "Næringsmiddelindustri",
        næringskoder = listOf("10")
    ),
    SYKEHUS(
        navn = "Sykehus",
        næringskoder = listOf("86101", "86102", "86104", "86105", "86106", "86107")
    ),
    SYKEHJEM(
        navn = "Sykehjem",
        næringskoder = listOf("87101", "87102")
    ),
    TRANSPORT(
        navn = "Transport",
        næringskoder = listOf("49100", "49311", "49391", "49392")
    ),
    BYGG(
        navn = "Bygg", næringskoder = listOf("41")
    ),
    ANLEGG(
        navn = "Anlegg", næringskoder = listOf("42")
    ),
}
