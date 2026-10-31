# Kotlin Problems

A plain Kotlin/JVM workspace for practicing data structures and algorithms.

## Requirements

- A Java runtime supported by Gradle (JDK 17 or newer) to start the wrapper, e.g. JDK 21.
- Internet access for the first build to download Gradle, dependencies, and Java toolchain.

The Java toolchain is used to download the required JDK if not available.

## Run the solutions

Run all problem tests:

```sh
./gradlew test
```

Run tests for one problem:

```sh
./gradlew :problems:test --tests '*TwoSumTest'
```

Test reports are written to `problems/build/reports/tests/test/index.html`.

## Code quality

Ktlint formats and lints Kotlin sources, tests, and Gradle Kotlin scripts.

```sh
./gradlew ktlintFormat  # Format files
./gradlew ktlintCheck   # Check formatting and lint without changing files
./gradlew check         # Run formatting checks, lint, and all tests
```

GitHub Actions runs the checks.

## Add a problem

1. Add a solution in `problems/src/main/kotlin/com/lordcodes/kotlinproblems/<topic>/` with a descriptive function name. Document its inputs, result, and complexity.
2. Add a matching test class under `problems/src/test/kotlin/com/lordcodes/kotlinproblems/<topic>/`. Use `kotlin.test.Test` and assertions; tests run on JUnit 5. Cover typical inputs and relevant edge cases.
3. Run `./gradlew :problems:test --tests '*YourProblemTest'`, then `./gradlew test` to run the full suite.
