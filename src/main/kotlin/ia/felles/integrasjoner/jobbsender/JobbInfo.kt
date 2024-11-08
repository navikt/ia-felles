package ia.felles.integrasjoner.jobbsender

interface JobbInfo {
    val jobb: Jobb
    val tidspunkt: String
    val parameter: String?
    val applikasjon: String
}
