package ia.felles.integrasjoner.kafkameldinger

interface SpørreundersøkelseMelding {
    val spørreundersøkelseId: String
    val orgnummer: String
    val virksomhetsNavn: String
    val status: SpørreundersøkelseStatus
    val type: String
    val temaMedSpørsmålOgSvaralternativer: List<TemaMelding>
}
