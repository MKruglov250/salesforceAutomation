pipeline {
    agent any

    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'development', name: 'BRANCH', type: 'PT_BRANCH'
      }

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven"
    }

    stages {
        stage('Test') {
            steps {
                // Get some code from a GitHub repository
                git branch: "${BRANCH}", url: 'https://github.com/MKruglov250/salesforceAutomation.git'

                // To run Maven on a Windows agent, use
                bat "mvn clean test -Dmaven.test.failure.ignore=true -Dbrowser=$BROWSER -Dlogin.page.url=$BASEURL -Dusername=$USERNAME -Dpassword=$PASSWORD -Dapi.url=$APIURL -Dsecurity.token=$VERIFICATIONCODE -Dclient.id=$CLIENT_ID -Dclient.secret=$CLIENT_SECRET"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }

            }
        }
        stage('Reporting') {
            steps {
                script {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'target/allure-results']]
                    ])
                }
            }
        }
    }
}