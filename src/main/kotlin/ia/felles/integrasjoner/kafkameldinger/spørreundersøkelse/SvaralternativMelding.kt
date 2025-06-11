package ia.felles.integrasjoner.kafkameldinger.spørreundersøkelse

@Deprecated(message = "Prøv å fjerne denne avhengigheten, ønsker å bevege oss bort fra interfaces for kafka meldingsvalidering")
interface SvaralternativMelding {
    val id: String
    val tekst: String
}
