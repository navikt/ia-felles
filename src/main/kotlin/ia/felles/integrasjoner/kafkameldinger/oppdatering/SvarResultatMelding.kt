package ia.felles.integrasjoner.kafkameldinger.oppdatering

interface SvarResultatMelding {
    val svarId: String
    val tekst: String
    val antallSvar: Int
}
