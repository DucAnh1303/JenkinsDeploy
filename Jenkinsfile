pipeline {
    agent any

    tools {
        gradlew 'gradle_7'
    }

    stages{
        stage('Build gradle'){
              steps{
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/DucAnh1303/JenkinsDeploy']])
                sh './gradlew clean build'
             }
        }
    }
}