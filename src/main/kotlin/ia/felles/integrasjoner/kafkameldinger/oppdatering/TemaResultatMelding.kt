package ia.felles.integrasjoner.kafkameldinger.oppdatering

interface TemaResultatMelding {
    val temaId: Int
    val navn: String?
    val spørsmålMedSvar: List<SpørsmålResultatMelding>
    val tema: String? // TODO: Deprecate
    val beskrivelse: String? // TODO: Deprecate
}
