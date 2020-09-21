plugins {
    java
}

group = "de.kevinw"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("junit", "junit", "4.12")

    // https://mvnrepository.com/artifact/io.micrometer/micrometer-core
    implementation("io.micrometer", "micrometer-core", "1.5.5")
    // https://mvnrepository.com/artifact/io.micrometer/micrometer-registry-prometheus
    implementation("io.micrometer", "micrometer-registry-prometheus", "1.5.5")
    // https://mvnrepository.com/artifact/org.aspectj/aspectjrt
    implementation("org.aspectj", "aspectjrt", "1.9.6")
    // https://mvnrepository.com/artifact/org.aspectj/aspectjweaver
    implementation("org.aspectj", "aspectjweaver", "1.9.6")
}
