plugins {
  kotlin("jvm") version "2.4.21" apply false
  id("org.jlleitschuh.gradle.ktlint") version "14.2.0"
  base
}

tasks.named("ktlintCheck") {
  dependsOn(":problems:ktlintCheck")
}

tasks.named("ktlintFormat") {
  dependsOn(":problems:ktlintFormat")
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
