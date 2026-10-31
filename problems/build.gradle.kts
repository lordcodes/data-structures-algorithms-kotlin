plugins {
  kotlin("jvm")
  id("org.jlleitschuh.gradle.ktlint")
}

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(27))
  }
}

kotlin {
  compilerOptions {
    jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_26)
  }
}

tasks.withType<JavaCompile>().configureEach {
  options.release.set(26)
}

dependencies {
  testImplementation(kotlin("test-junit5"))
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
  useJUnitPlatform()
}
