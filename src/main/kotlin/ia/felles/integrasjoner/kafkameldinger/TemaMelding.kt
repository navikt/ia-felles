package ia.felles.integrasjoner.kafkameldinger

interface TemaMelding {
    val temaId: Int
    val navn: String
    val spørsmålOgSvaralternativer: List<SpørsmålMelding>
}
