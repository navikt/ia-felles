package ia.felles.integrasjoner.kafkameldinger.spørreundersøkelse

@Deprecated(message = "Prøv å fjerne denne avhengigheten, ønsker å bevege oss bort fra interfaces for kafka meldingsvalidering")
interface SpørreundersøkelseMelding {
    val id: String
    val type: String
    val status: SpørreundersøkelseStatus
    val orgnummer: String
    val virksomhetsNavn: String
    val samarbeidsNavn: String
    val temaer: List<TemaMelding>
}
