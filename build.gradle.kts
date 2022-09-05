plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.5.2"
}

group = "cn.tannn"
version = "1.0.1"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

// Configure Gradle IntelliJ Plugin - read more: https://github.com/JetBrains/gradle-intellij-plugin
intellij {
    version.set("2022.1.2")
    type.set("IC") // Target IDE Platform

    plugins.set(listOf(/* Plugin Dependencies */))
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "11"
        targetCompatibility = "11"
        options.encoding = "UTF-8"
    }
    buildSearchableOptions {
        enabled = false
    }
    patchPluginXml {
        version.set("${project.version}")
        sinceBuild.set("213")
        untilBuild.set("222.*")
    }



}
