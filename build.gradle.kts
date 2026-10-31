plugins {
    kotlin("jvm") version "2.4.21" apply false
    base
}

tasks.named("check") {
    dependsOn(":problems:check")
}

tasks.named("build") {
    dependsOn(":problems:build")
}

tasks.named("clean") {
    dependsOn(":problems:clean")
}
