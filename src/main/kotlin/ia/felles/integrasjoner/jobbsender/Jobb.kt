package ia.felles.integrasjoner.jobbsender

enum class Jobb {
    @Suppress("ktlint:standard:enum-entry-name-case")
    ryddeIUrørteSaker,

    @Suppress("ktlint:standard:enum-entry-name-case")
    ryddeIUrørteSakerTørrKjør,

    @Suppress("ktlint:standard:enum-entry-name-case")
    iaSakEksport,

    @Suppress("ktlint:standard:enum-entry-name-case")
    iaSakStatistikkEksport,

    @Suppress("ktlint:standard:enum-entry-name-case")
    iaSakStatusExport,

    @Suppress("ktlint:standard:enum-entry-name-case")
    iaSakLeveranseEksport,

    @Suppress("ktlint:standard:enum-entry-name-case")
    iaSakSamarbeidEksport,

    @Suppress("ktlint:standard:enum-entry-name-case")
    iaSakSamarbeidBigQueryEksport,

    @Suppress("ktlint:standard:enum-entry-name-case")
    spørreundersøkelseBigQueryEksport,

    @Suppress("ktlint:standard:enum-entry-name-case")
    iaSakSamarbeidsplanEksport,

    @Suppress("ktlint:standard:enum-entry-name-case")
    iaSakSamarbeidsplanBigqueryEksport,

    @Suppress("ktlint:standard:enum-entry-name-case")
    næringsImport,

    @Suppress("ktlint:standard:enum-entry-name-case")
    materializedViewOppdatering,

    @Suppress("ktlint:standard:enum-entry-name-case")
    alleKategorierSykefraværsstatistikkDvhImport,

    @Suppress("ktlint:standard:enum-entry-name-case")
    landSykefraværsstatistikkDvhImport,

    @Suppress("ktlint:standard:enum-entry-name-case")
    sektorSykefraværsstatistikkDvhImport,

    @Suppress("ktlint:standard:enum-entry-name-case")
    næringSykefraværsstatistikkDvhImport,

    @Suppress("ktlint:standard:enum-entry-name-case")
    næringskodeSykefraværsstatistikkDvhImport,

    @Suppress("ktlint:standard:enum-entry-name-case")
    bransjeSykefraværsstatistikkDvhImport,

    @Suppress("ktlint:standard:enum-entry-name-case")
    virksomhetSykefraværsstatistikkDvhImport,

    @Suppress("ktlint:standard:enum-entry-name-case")
    virksomhetMetadataSykefraværsstatistikkDvhImport,

    @Suppress("ktlint:standard:enum-entry-name-case")
    publiseringsdatoDvhImport,

    @Suppress("ktlint:standard:enum-entry-name-case")
    kalkulerResulterendeStatusForHendelser,

    @Suppress("ktlint:standard:enum-entry-name-case")
    engangsJobb,
}
