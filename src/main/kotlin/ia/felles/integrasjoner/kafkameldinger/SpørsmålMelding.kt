package ia.felles.integrasjoner.kafkameldinger

interface SpørsmålMelding{
    val id: String
    val spørsmål: String
    val flervalg: Boolean
    val svaralternativer: List<SvaralternativMelding>
}