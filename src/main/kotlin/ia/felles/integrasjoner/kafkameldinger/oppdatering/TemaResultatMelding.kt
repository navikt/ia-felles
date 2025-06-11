package ia.felles.integrasjoner.kafkameldinger.oppdatering

@Deprecated(message = "Prøv å fjerne denne avhengigheten, ønsker å bevege oss bort fra interfaces for kafka meldingsvalidering")
interface TemaResultatMelding {
    val id: Int
    val navn: String
    val spørsmålMedSvar: List<SpørsmålResultatMelding>
}
