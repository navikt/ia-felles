package ia.felles.definisjoner.bransjer

/*

Definisjonen av bransjer er hentet fra arbeidsmiljøportalen:

*/

enum class Bransje(val navn: String, val bransjeId: BransjeId) {
    BARNEHAGER(
        navn = "Barnehager",
        bransjeId = BransjeId.Næringskoder("88911")
    ),
    NÆRINGSMIDDELINDUSTRI(
        navn = "Næringsmiddelindustri",
        bransjeId = BransjeId.Næring("10")
    ),
    SYKEHUS(
        navn = "Sykehus",
        bransjeId = BransjeId.Næringskoder("86101", "86102", "86104", "86105", "86106", "86107")
    ),
    SYKEHJEM(
        navn = "Sykehjem",
        bransjeId = BransjeId.Næringskoder("87101", "87102")
    ),
    TRANSPORT(
        navn = "Transport",
        bransjeId = BransjeId.Næringskoder("49100", "49311", "49312", "49391", "49392")
    ),
    BYGG(
        navn = "Bygg", bransjeId = BransjeId.Næring("41")
    ),
    ANLEGG(
        navn = "Anlegg", bransjeId = BransjeId.Næring("42")
    );

    companion object {
        fun fra(næringskode: String): Bransje? = Bransje.values().firstOrNull {
            when (it.bransjeId) {
                is BransjeId.Næring -> it.bransjeId.næring == næringskode.take(2)
                is BransjeId.Næringskoder -> it.bransjeId.næringskoder.contains(næringskode)
            }
        }
    }
}
