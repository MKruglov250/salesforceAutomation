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
                bat "mvn clean test -Dmaven.test.failure.ignore=true -Dbrowser=$BROWSER -DLoginUrl=$LOGINURL -Dlogin=$LOGIN -Dpassword=$PASSWORD -DApiUrl=$APIURL -DverificationCode=$VERIFICATIONCODE -Dclient_id=$CLIENT_ID -Dclient_secret=$CLIENT_SECRET -Dgrant_type=$GRANTTYPE"
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