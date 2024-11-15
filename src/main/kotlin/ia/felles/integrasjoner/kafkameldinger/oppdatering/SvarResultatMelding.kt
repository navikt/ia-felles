package ia.felles.integrasjoner.kafkameldinger.oppdatering

interface SvarResultatMelding {
    val id: String
    val tekst: String
    val antallSvar: Int
}
