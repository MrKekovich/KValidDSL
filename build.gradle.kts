plugins {
    kotlin("jvm") version "1.9.21"
    `maven-publish`
}

group = "io.github.mrkekovich"
version = "0.1.2"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation(kotlin("reflect"))
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "io.github.mrkekovich"
            artifactId = "kvalid-dsl"
            version = "0.1.2"

            from(components["java"])
        }
    }
}
