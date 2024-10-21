package ia.felles.integrasjoner.kafkameldinger

interface TemaMelding {
    val temaId: Int
    val navn: String? // TODO: Gjør ikke-nullable når gamle meldinger har gått ut på dato
    val temanavn: Temanavn? // TODO Deprecate
    val beskrivelse: String? // TODO Deprecate
    val introtekst: String? // TODO Deprecate
    val spørsmålOgSvaralternativer: List<SpørsmålMelding>
}
