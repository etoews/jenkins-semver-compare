@Library('semver-compare-lib') _

pipeline {
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
                            result = semver_compare(desired_version, current_version)
                        }
                        catch(err) {
                            echo "${err}"
                            continue
                        }

                        echo "in pipeline: result: ${result}"

                        if (result > 0) {
                            echo "Desired Version ${desired_version} of the EdPay DAL Schema is greater than Current Version ${current_version}, applying EdPay DAL Schema to DB."
                        }
                        else {
                            echo "Desired Version ${desired_version} of the EdPay DAL Schema is less than or equal to Current Version ${current_version}, skipping apply."
                        }
                    }
                }
            }
        }
    }
}
