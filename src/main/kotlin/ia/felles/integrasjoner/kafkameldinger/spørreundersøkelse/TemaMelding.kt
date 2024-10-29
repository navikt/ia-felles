package ia.felles.integrasjoner.kafkameldinger.spørreundersøkelse

interface TemaMelding {
    val id: Int
    val navn: String
    val spørsmål: List<SpørsmålMelding>

    @Deprecated("Bruk Id")
    val temaId: Int?

    @Deprecated("Bruk spørsmål")
    val spørsmålOgSvaralternativer: List<SpørsmålMelding>?
}
