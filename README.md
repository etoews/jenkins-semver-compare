# Semantic Version Comparison in a Jenkins pipeline

A Jenkins global pipeline library method [semver_compare](vars/semver_compare.groovy) and an example [Jenkinsfile](Jenkinsfile) for how to use it.

## Running tests

Gradle is used to run tests for the SemanticVersion class used in this library.
The repository comes with [Gradle wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html), a helper script to automatically download and manage the gradle distribution.
Invoke the wrapper script according to the OS platform:

UNIX/Linux

    ./gradlew test

Windows (untested)

    gradlew.bat test

[1] https://docs.gradle.org/current/userguide/gradle_wrapper.html
