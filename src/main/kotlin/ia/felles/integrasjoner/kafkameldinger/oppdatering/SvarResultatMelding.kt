package ia.felles.integrasjoner.kafkameldinger.oppdatering

@Deprecated(message = "Prøv å fjerne denne avhengigheten, ønsker å bevege oss bort fra interfaces for kafka meldingsvalidering")
interface SvarResultatMelding {
    val id: String
    val tekst: String
    val antallSvar: Int
}
