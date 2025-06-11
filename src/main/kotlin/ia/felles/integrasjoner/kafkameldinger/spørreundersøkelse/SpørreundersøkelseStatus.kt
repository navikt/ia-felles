package ia.felles.integrasjoner.kafkameldinger.spørreundersøkelse

@Deprecated(message = "Prøv å fjerne denne avhengigheten, ønsker å bevege oss bort fra interfaces for kafka meldingsvalidering")
enum class SpørreundersøkelseStatus {
    OPPRETTET,
    PÅBEGYNT,
    AVSLUTTET,
    SLETTET,
}
