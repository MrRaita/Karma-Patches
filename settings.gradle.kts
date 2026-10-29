// TODO: Morphe şablonundaki settings.gradle.kts ile eşleştir (özellikle Morphe paket deposu)
pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
        // TODO: Morphe patcher'ın yayınlandığı depoyu şablondan buraya ekle
    }
}

rootProject.name = "nowtv-patches"
include(":patches")
