pipeline {
    agent any

    tools{
        gradle 'gradle_7'
    }

    stages {
        stage('build') {
           steps {
               sh './gradlew --version'
               sh 'java --version'
               sh './gradlew clean build'
           }
        }
    }
}
