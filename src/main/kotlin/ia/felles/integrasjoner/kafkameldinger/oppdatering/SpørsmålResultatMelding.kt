package ia.felles.integrasjoner.kafkameldinger.oppdatering

interface SpørsmålResultatMelding {
    val id: String
    val tekst: String
    val flervalg: Boolean
    val svarListe: List<SvarResultatMelding>
}
