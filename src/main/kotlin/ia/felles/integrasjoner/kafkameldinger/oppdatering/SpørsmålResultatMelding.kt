package ia.felles.integrasjoner.kafkameldinger.oppdatering

@Deprecated(message = "Prøv å fjerne denne avhengigheten, ønsker å bevege oss bort fra interfaces for kafka meldingsvalidering")
interface SpørsmålResultatMelding {
    val id: String
    val tekst: String
    val flervalg: Boolean
    val svarListe: List<SvarResultatMelding>
}
