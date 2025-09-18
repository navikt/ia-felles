
group = "com.github.navikt"
version = properties["version"] ?: "local-build"
val packageName = "ia-felles"

repositories {
    maven("https://jitpack.io")
    maven("https://packages.confluent.io/maven/")
    mavenCentral()
}

plugins {
    kotlin("jvm") version "2.2.20"
    `java-library`
    `maven-publish`
}

dependencies {
    implementation(kotlin("stdlib", "2.2.20"))
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom:2.2.20"))
    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    // Use the Kotlin JUnit integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

kotlin {
    jvmToolchain(17)
}

publishing {

    publications {

        val repository = "https://github.com/navikt/ia-felles"
        create<MavenPublication>("mavenJava") {
            pom {
                name.set(packageName)
                description.set("Felles definisjoner og modeller for IA-domenenet")
                url.set(repository)

                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }

                scm {
                    connection.set("scm:git:$repository.git")
                    developerConnection.set("scm:git:$repository.git")
                    url.set(repository)
                }
            }
            from(components["java"])
        }
    }
}
