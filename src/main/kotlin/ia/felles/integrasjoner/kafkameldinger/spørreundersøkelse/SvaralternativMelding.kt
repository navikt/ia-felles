package ia.felles.integrasjoner.kafkameldinger.spørreundersøkelse

interface SvaralternativMelding {
    val id: String
    val tekst: String

    @Deprecated("Bruk id")
    val svarId: String?

    @Deprecated("Bruk tekst")
    val svartekst: String?
}
