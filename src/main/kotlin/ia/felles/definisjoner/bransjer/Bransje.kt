package ia.felles.definisjoner.bransjer

/*

Definisjonen av bransjer er hentet fra arbeidsmiljøportalen:

*/

private infix fun BransjeId.union(other: BransjeId): BransjeId =
    if (this is BransjeId.Næringskoder && other is BransjeId.Næringskoder)
        BransjeId.Næringskoder((næringskoder + other.næringskoder).distinct())
    else this

enum class Bransje(
    val navn: String,
    val bransjeId: BransjeId,
) {
    BARNEHAGER(
        navn = BransjeSN2007.BARNEHAGER.navn,
        bransjeId = BransjeSN2007.BARNEHAGER.bransjeId union BransjeSN2025.BARNEHAGER.bransjeId,
    ),
    NÆRINGSMIDDELINDUSTRI(
        navn = BransjeSN2007.NÆRINGSMIDDELINDUSTRI.navn,
        bransjeId = BransjeSN2007.NÆRINGSMIDDELINDUSTRI.bransjeId,
    ),
    SYKEHUS(
        navn = BransjeSN2007.SYKEHUS.navn,
        bransjeId = BransjeSN2007.SYKEHUS.bransjeId union BransjeSN2025.SYKEHUS.bransjeId,
    ),
    SYKEHJEM(
        navn = BransjeSN2007.SYKEHJEM.navn,
        bransjeId = BransjeSN2007.SYKEHJEM.bransjeId union BransjeSN2025.SYKEHJEM.bransjeId,
    ),
    TRANSPORT(
        navn = BransjeSN2007.TRANSPORT.navn,
        bransjeId = BransjeSN2007.TRANSPORT.bransjeId union BransjeSN2025.TRANSPORT.bransjeId,
    ),
    BYGG(
        navn = BransjeSN2007.BYGG.navn,
        bransjeId = BransjeSN2007.BYGG.bransjeId,
    ),
    ANLEGG(
        navn = BransjeSN2007.ANLEGG.navn,
        bransjeId = BransjeSN2007.ANLEGG.bransjeId,
    ),
    ;

    companion object {
        fun fra(næringskode: String) = BransjeId.fra(entries, { it.bransjeId }, næringskode)
    }
}
