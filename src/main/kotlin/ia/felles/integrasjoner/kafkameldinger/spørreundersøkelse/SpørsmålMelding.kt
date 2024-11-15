package ia.felles.integrasjoner.kafkameldinger.spørreundersøkelse

interface SpørsmålMelding {
    val id: String
    val tekst: String
    val flervalg: Boolean
    val svaralternativer: List<SvaralternativMelding>
}
