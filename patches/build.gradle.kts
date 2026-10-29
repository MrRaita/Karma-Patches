group = "dev.nowtvpatches"

patches {
    about {
        name = "NOW TV Patches"
        description = "Custom patches for the NOW TV Android app"
        source = "https://github.com/MrRaita/Karma-Patch"
        author = "MrRaita"
        contact = "https://github.com/MrRaita"
        website = "https://github.com/MrRaita/Karma-Patch"
        license = "GPLv3"
    }
}

val patchListGeneratorClasspath = configurations.create("patchListGeneratorClasspath")

dependencies {
    compileOnly(libs.gson)
    patchListGeneratorClasspath(libs.gson)
}

tasks {
    register<JavaExec>("generatePatchesList") {
        description = "Build patch with patch list"
        dependsOn(build)
        classpath = sourceSets["main"].runtimeClasspath + patchListGeneratorClasspath
        mainClass.set("util.PatchListGeneratorKt")
    }

    publish {
        dependsOn("generatePatchesList")
    }
}
