import java.io.FileNotFoundException

plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.8.0"
}

group = "dev"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.swiftnav:sbp:4.8.0")
    implementation("org.json:json:20220924")
    implementation("org.jetbrains:marketplace-zip-signer:0.1.8")
}

// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    version.set("2021.3.3")
    type.set("IC") // Target IDE Platform

    plugins.set(listOf(/* Plugin Dependencies */))
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "11"
        targetCompatibility = "11"
    }

    patchPluginXml {
        sinceBuild.set("213")
        untilBuild.set("223.*")
    }

    signPlugin {
        val cc = System.getenv("CHAIN") ?: ""
        val pk = System.getenv("PRIVATE") ?: ""
        try {
            certificateChain.set(File(cc).readText())
            privateKey.set(File(pk).readText())
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }
}
