plugins {
    kotlin("jvm") version "1.9.21"
    `maven-publish`
}

group = "io.github.mrkekovich"
version = "0.1.3"

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
            version = "0.1.3"

            from(components["java"])
        }
    }
}
