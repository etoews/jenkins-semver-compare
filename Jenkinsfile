@Library('semver-compare-lib@1.0.0') _

pipeline {
    agent {
        node {
            label "master"
        }
    }

    stages {
        stage("Semver compare") {
            steps {
                script {
                    desired_versions = ["2.0.0-rc.8", "2.0.0",      "1.0.0-rc.7", "1.0.0-rc.7", "foo"]
                    current_versions = ["2.0.0-rc.7", "1.0.0-rc.7", "1.0.0-rc.7", "2.0.0",      "bar"]

                    for (int i=0; i < desired_versions.size(); i++) {
                        desired_version = desired_versions[i]
                        current_version = current_versions[i]

                        try {
                            semver_compare_result = semver_compare(desired_version, current_version)
                            echo "semver_compare_result: ${semver_compare_result}"
                        }
                        catch(err) {
                            echo "${err}"
                            continue
                        }

                        if (semver_compare_result > 0) {
                            echo "Desired Version ${desired_version} is greater than Current Version ${current_version}, execute action."
                        }
                        else {
                            echo "Desired Version ${desired_version} is less than or equal to Current Version ${current_version}, skip action."
                        }
                    }
                }
            }
        }
    }
}
