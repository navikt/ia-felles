package ia.felles.definisjoner.bransjer

sealed class BransjeId {
    data class Næring(
        val næring: String,
    ) : BransjeId() {
        init {
            require(næring.matches(Regex("""\d{2}""")))
        }
    }

    data class Næringskoder(
        val næringskoder: List<String>,
    ) : BransjeId() {
        constructor(vararg næringskoder: String) : this(næringskoder.toList())

        init {
            require(næringskoder.isNotEmpty())
            require(næringskoder.all { it.matches(Regex("""\d{5}""")) })
        }
    }
}
