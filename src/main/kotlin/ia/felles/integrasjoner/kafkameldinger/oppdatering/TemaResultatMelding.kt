package ia.felles.integrasjoner.kafkameldinger.oppdatering

interface TemaResultatMelding {
    val id: Int
    val navn: String
    val spørsmålMedSvar: List<SpørsmålResultatMelding>
}
