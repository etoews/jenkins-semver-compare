#!/usr/bin/groovy

import io.github.etoews.SemanticVersion

def call(DESIRED_VERSION, CURRENT_VERSION) {
    echo "semver_compare: ${DESIRED_VERSION} ${CURRENT_VERSION}"

    SemanticVersion desired_version_semver = new SemanticVersion(this)
    desired_version_semver.setSemanticVersion(DESIRED_VERSION)

    SemanticVersion current_version_semver = new SemanticVersion(this)
    current_version_semver.setSemanticVersion(CURRENT_VERSION)

    return desired_version_semver.compareTo(current_version_semver)
}
