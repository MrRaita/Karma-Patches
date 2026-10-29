// TODO: Morphe şablonundaki patches/build.gradle.kts ile değiştir.
// Önemli olan: bağımlılık (morphe patcher), Kotlin JVM hedefi ve .mpp üreten görev.
plugins {
    kotlin("jvm")
}

kotlin { jvmToolchain(17) }

dependencies {
    // implementation("app.morphe:morphe-patcher:<sürüm>")   // şablondaki satırı kullan
}
