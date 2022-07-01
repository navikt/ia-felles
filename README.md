# ia-felles-definisjoner


[![](https://jitpack.io/v/navikt/ia-felles.svg)](https://jitpack.io/#navikt/ia-felles)

## Hva er dette biblioteket?

`ia-felles-definisjoner` er et bibliotek som inneholder definisjoner for IA-domenet. 
Foreløpig gjelder dette bare bransjeprogram, som definert i [Arbeidsmiljøportalen](https://www.arbeidsmiljoportalen.no/).

## Hvordan ta biblioteket i bruk

I din `build.gradle.kts`-fil:

```kotlin
repositories {
    // ...andre repositories
    maven("https://jitpack.io")
}
```

```kotlin
dependencies {
    // ...andre dependencies
    implementation("com.github.navikt:ia-felles:<versjon>")
}
```

De ulike versjonene finnes under releases på GitHub, eller direkte på [Jitpack](https://jitpack.io/#navikt/ia-felles). 
