package ia.felles.integrasjoner.kafkameldinger.spørreundersøkelse

interface SpørreundersøkelseMelding {
    val id: String
    val type: String
    val status: SpørreundersøkelseStatus
    val orgnummer: String
    val virksomhetsNavn: String
    val samarbeidsNavn: String?
    val temaer: List<TemaMelding>

    @Deprecated("Bruk temaer")
    val temaMedSpørsmålOgSvaralternativer: List<TemaMelding>?

    @Deprecated("Bruk Id")
    val spørreundersøkelseId: String?
}
