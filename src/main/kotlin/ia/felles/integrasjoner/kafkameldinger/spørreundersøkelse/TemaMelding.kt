package ia.felles.integrasjoner.kafkameldinger.spørreundersøkelse

interface TemaMelding {
    val id: Int
    val navn: String
    val spørsmål: List<SpørsmålMelding>
}
