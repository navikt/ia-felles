package ia.felles.integrasjoner.kafkameldinger

interface TemaMelding {
    val temaId: Int
    val navn: String? //TODO: Gjør ikke-nullable når gamle meldinger har gått ut på dato
    val temanavn: Temanavn? //TODO DEPRECATED, skal slettes og erstattes med navn
    val beskrivelse: String? //TODO DEPRECATED, ikke lenger i bruk
    val introtekst: String? //TODO DEPRECATED, ikke lenger i bruk
    val spørsmålOgSvaralternativer: List<SpørsmålMelding>
}