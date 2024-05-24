# ia-felles-definisjoner


[![](https://jitpack.io/v/navikt/ia-felles.svg)](https://jitpack.io/#navikt/ia-felles)

## Hva er dette biblioteket?

`ia-felles-definisjoner` er et bibliotek som inneholder definisjoner for IA-domenet. 
Foreløpig gjelder dette bare bransjeprogram, som definert i [Arbeidsmiljøportalen](https://www.arbeidsmiljoportalen.no/).

## Hvordan ta biblioteket i bruk?

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

## Hvordan lage (og eventuelt slette) en ny release?

### Hva skal release hete?

Vi bruker [semantic versjoning](https://semver.org/spec/v2.0.0.html) og en liten ```v``` før navnet til packe. Som f.eks: ``v1.1.0``

 
Bruk gjerne "-RC" (release candidate) eller "snapshot" sufiks i navnet til release du lager dersom du ønsker å verifisere ``ìa-felles`` fra en annnen applikasjon med avhengighet til ``ia-felles``. 

Du kan f.eks opprette ``v1.1.0-RC`` versjon av biblioteket ut i fra en ``v1.1.0`` tag og teste biblioteket fra applikasjonen med avhengighet til ``ia-felles``. Hvis testen er vellyket kan du lage en ``v1.1.0`` fra samme tag senere.

Slett gjerne den ``v1.1.0-RC`` release candidate versjonen etterpå. 


### Slik gjør du det 
Fra prosjektet i GitHub naviger til [releases](https://github.com/navikt/ia-felles/releases) (lenken finnes på høyre siden under "About")

Opprett en ny release ved å clicke på knappen "Draft a new release"

Ved "Choose a tag" bruk en eksisterende tag eller opprett en ny tag (da kan du velge branch tag skal lages fra)

La "Previous tag" til "auto"

Angi en god beskrivelse på release 

Avhengig om release er en release-candidate eller en production-ready release velg "Set as a pre-release" eller "Set as
the latest release" i check-box nederst på siden

Trykk "Publish release"

Gå til [Jitpack](https://jitpack.io/#navikt/ia-felles) og velg "Get it" hvor opplysninger om din release står. Dette vil starte en build og gjøre artifactene tilgjengelige for nedlasting etter build er ferdig.

### Slette en release 
Fra [release oversikt](https://github.com/navikt/ia-felles/releases) på GitHub, bruk delete knappen (søppelbøtte ikon). Dette vil automatisk gjøre forrige release som __latest__ 

På den samme måten kan du da slette tilsvarende tag fra [tag oversikt](https://github.com/navikt/ia-felles/tags) på GitHub. 

Du kan også slette release i Jitpack (mulig den blir slettet automatisk noen minutter etter både release og tag blir slettet). 

Åpne [Jitpack](https://jitpack.io/#navikt/ia-felles), login med GitHub og bruk den slett knappen ved siden av release (en rød kryss). Info om release vil forsvinne etter noen minutter. 

